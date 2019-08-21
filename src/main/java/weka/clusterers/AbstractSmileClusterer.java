/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * AbstractSmileClusterer.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package weka.clusterers;

import smile.clustering.PartitionClustering;
import smile.data.AttributeDataset;
import weka.core.DatasetUtils;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;

/**
 * Ancestor for SMILE clustering algorithms.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public abstract class AbstractSmileClusterer
  extends AbstractClusterer {

  private static final long serialVersionUID = 8061087017316008521L;

  /** the dataset structure. */
  protected AttributeDataset m_Header;

  /** the model. */
  protected smile.clustering.Clustering<double[]> m_Model;

  /**
   * Resets the scheme.
   */
  protected void reset() {
    m_Header = null;
    m_Model  = null;
  }

  /**
   * Builds the clusterer.
   *
   * @param data	the data to use for training
   * @return 		the generated model
   * @throws Exception	if training fails or data does not match capabilities
   */
  protected abstract smile.clustering.Clustering<double[]> buildClusterer(AttributeDataset data) throws Exception;

  /**
   * Builds the clusterer.
   *
   * @param data	the data to use for training
   * @throws Exception	if training fails or data does not match capabilities
   */
  @Override
  public void buildClusterer(Instances data) throws Exception {
    AttributeDataset	dataset;

    reset();
    getCapabilities().testWithFail(data);
    dataset = DatasetUtils.convertInstances(data);
    m_Header = dataset.head(0);
    m_Model  = buildClusterer(dataset);
  }

  /**
   * Classifies the specified instance.
   *
   * @param instance	the instance to classify
   * @return		the classification
   * @throws Exception	if classification fails
   */
  @Override
  public int clusterInstance(Instance instance) throws Exception {
    double[]	values;

    values = DatasetUtils.convertInstance(instance, m_Header);
    return m_Model.predict(values);
  }

  /**
   * Returns the number of clusters.
   *
   * @return the number of clusters generated for a training dataset.
   * @throws Exception if number of clusters could not be returned
   *              successfully
   */
  @Override
  public int numberOfClusters() throws Exception {
    if (m_Model instanceof PartitionClustering)
      return ((PartitionClustering<double[]>) m_Model).getNumClusters();
    else
      throw new IllegalStateException("Retrieval of number of clusters is not supported!");
  }

  /**
   * Outputs some information about the model.
   *
   * @return		the model
   */
  @Override
  public String toString() {
    if (m_Model == null)
      return Utils.toCommandLine(this) + "\n" + "No model built yet!\n";
    else
      return Utils.toCommandLine(this) + "\n" + m_Model.getClass().getName() + "\n";
  }
}
