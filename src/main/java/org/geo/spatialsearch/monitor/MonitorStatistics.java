package org.geo.spatialsearch.monitor;

/**
 * 
 * @author Santosh Moghulla
 *
 */
public interface MonitorStatistics {

	String getName();

	long getLastCallTime();

	long getCallCount();

	long getAverageCallTime();

	long getTotalCallTime();

	long getMinimumCallTime();

	long getMaximumCallTime();

}
