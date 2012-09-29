package org.geo.spatialsearch.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.geo.spatialsearch.monitor.Monitor;
import org.geo.spatialsearch.monitor.MonitorFactory;
import org.geo.spatialsearch.monitor.GlobalMonitorStatistics;
import org.geo.spatialsearch.rest.APIResponse;

/**
 * An aspect that monitors the performance of all three repositories used in the
 * application.
 *
 */
@Aspect
public class PerformanceMonitor {

	private final Log logger = LogFactory.getLog(getClass());

	private MonitorFactory monitorFactory;

	public PerformanceMonitor(MonitorFactory monitorFactory) {
		this.monitorFactory = monitorFactory;
	}

	/**
	 * Times api method invocations and outputs performance results to a Log4J
	 * logger.
	 *
	 * @param method The join point representing the intercepted repository
	 *            method
	 * @return The object returned by the target method
	 * @throws Throwable if thrown by the target method
	 */
	@Around("execution(public * org.geo.spatialsearch.*.service.impl.*ServiceImpl+.*(..)) && "
			+ "@annotation(org.geo.spatialsearch.util.ResponseTime)")
	public APIResponse monitor(ProceedingJoinPoint method) throws Throwable {
		String name = createJoinPointTraceName(method);
		Monitor monitor = monitorFactory.start(name);
		try {
			APIResponse apiResponse = (APIResponse) method.proceed();
			monitor.stop();
			apiResponse.setResponseTime(((GlobalMonitorStatistics) monitorFactory).lastCallTime(name));
			return apiResponse;
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug(monitor);
			}
		}
	}

	private String createJoinPointTraceName(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		StringBuilder sb = new StringBuilder();
		sb.append(signature.getDeclaringType().getSimpleName());
		sb.append('.').append(signature.getName());
		return sb.toString();
	}
}