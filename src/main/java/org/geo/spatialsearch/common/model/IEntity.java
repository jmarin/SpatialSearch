package org.geo.spatialsearch.common.model;

import java.io.Serializable;

/**
 *
 * Interface marks class which can be persisted.
 *
 *
 * @param <K> type of primary key which must be serializable
 */

public interface IEntity<K extends Serializable> {

	public K getId();

	public void setId(K id);
}
