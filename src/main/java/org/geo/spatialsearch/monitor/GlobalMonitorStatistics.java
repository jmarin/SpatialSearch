package org.geo.spatialsearch.monitor;

import java.util.Date;

/**
 * 
 * @author Santosh Moghulla
 *
 */
public interface GlobalMonitorStatistics {

	long getCallsCount();

	long getTotalCallTime();

	Date getLastAccessTime();

	long lastCallTime(String methodName);

	long callCount(String methodName);

	long averageCallTime(String methodName);

	long totalCallTime(String methodName);

	long minimumCallTime(String methodName);

	long maximumCallTime(String methodName);
}
