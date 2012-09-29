package org.geo.spatialsearch.monitor.jamon;


import java.util.Date;

import org.geo.spatialsearch.monitor.GlobalMonitorStatistics;
import org.geo.spatialsearch.monitor.Monitor;
import org.geo.spatialsearch.monitor.MonitorFactory;

import com.jamonapi.MonitorComposite;

/**
 * 
 * @author Santosh Moghulla
 *
 */
public class JamonMonitorFactory implements MonitorFactory, GlobalMonitorStatistics {

	private com.jamonapi.MonitorFactoryInterface monitorFactory = com.jamonapi.MonitorFactory.getFactory();

	@Override
	public Monitor start(String name) {
		return new JamonMonitor(monitorFactory.start(name));
	}

	@Override
	public long getCallsCount() {
		return (long) getMonitors().getHits();
	}

	@Override
	public long getTotalCallTime() {
		return (long) getMonitors().getTotal();
	}

	@Override
	public Date getLastAccessTime() {
		return getMonitors().getLastAccess();
	}

	public MonitorComposite getMonitors() {
		return monitorFactory.getRootMonitor();
	}

	@Override
	public long averageCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getAvg();
	}

	@Override
	public long callCount(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getHits();
	}

	@Override
	public long lastCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getLastValue();
	}

	@Override
	public long maximumCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getMax();
	}

	@Override
	public long minimumCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getMin();
	}

	@Override
	public long totalCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getTotal();
	}

}
