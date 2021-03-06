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
 * SmilePolynomialKernelBase.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package smile.math.kernel;

import weka.core.Utils;
import weka.core.WekaOptionUtils;
import smile.math.kernel.AbstractSmileKernel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Superclass for SmilePolynomialKernel containing the option handling.
 *
 * @author FracPete
 */
public abstract class SmilePolynomialKernelBase
  extends AbstractSmileKernel<smile.math.kernel.PolynomialKernel> {

  /** the flag for {@link #m_Degree}. */
  public final static String DEGREE = "degree";

  /** the flag for {@link #m_Scale}. */
  public final static String SCALE = "scale";

  /** the flag for {@link #m_Offset}. */
  public final static String OFFSET = "offset";

  /** the polynomial degree. */
  protected int m_Degree = getDefaultDegree();

  /** the scale. */
  protected double m_Scale = getDefaultScale();

  /** the offset value. */
  protected double m_Offset = getDefaultOffset();

  /**
   * Returns a desription of the class.
   *
   * @return the description
   */
  public abstract String globalInfo();

  /**
   * Returns an enumeration describing the available options.
   *
   * @return an enumeration of all the available options.
   */
  @Override
  public Enumeration listOptions() {
    Vector result = new Vector();
    WekaOptionUtils.addOption(result, degreeTipText(), "" + getDefaultDegree(), DEGREE);
    WekaOptionUtils.addOption(result, scaleTipText(), "" + getDefaultScale(), SCALE);
    WekaOptionUtils.addOption(result, offsetTipText(), "" + getDefaultOffset(), OFFSET);
    WekaOptionUtils.add(result, super.listOptions());
    return WekaOptionUtils.toEnumeration(result);
  }

  /**
   * Parses a given list of options.
   *
   * @param options the list of options as an array of strings
   * @throws Exception if an option is not supported
   */
  @Override
  public void setOptions(String[] options) throws Exception {
    setDegree(WekaOptionUtils.parse(options, DEGREE, getDefaultDegree()));
    setScale(WekaOptionUtils.parse(options, SCALE, getDefaultScale()));
    setOffset(WekaOptionUtils.parse(options, OFFSET, getDefaultOffset()));
    super.setOptions(options);
  }

  /**
   * Gets the current settings.
   *
   * @return an array of strings suitable for passing to setOptions
   */
  @Override
  public String[] getOptions() {
    List<String> result = new ArrayList<String>();
    WekaOptionUtils.add(result, DEGREE, getDegree());
    WekaOptionUtils.add(result, SCALE, getScale());
    WekaOptionUtils.add(result, OFFSET, getOffset());
    WekaOptionUtils.add(result, super.getOptions());
    return WekaOptionUtils.toArray(result);
  }

  /**
   * The default value for degree.
   *
   * @return the default value
   * @see #m_Degree
   */
  protected int getDefaultDegree() {
    return 2;
  }

  /**
   * Returns the polynomial degree.
   *
   * @return the current value (value > 0)
   * @see #m_Degree
   */
  public int getDegree() {
    return m_Degree;
  }

  /**
   * Sets the polynomial degree.
   *
   * @param value the new value (value > 0)
   * @see #m_Degree
   */
  public void setDegree(int value) {
    if (value > 0) {
      m_Degree = value;
    }
  }

  /**
   * Returns the help string for degree.
   *
   * @return the help string
   * @see #m_Degree
   */
  public String degreeTipText() {
    return "The polynomial degree; value > 0.";
  }

  /**
   * The default value for scale.
   *
   * @return the default value
   * @see #m_Scale
   */
  protected double getDefaultScale() {
    return 1.0;
  }

  /**
   * Returns the scale.
   *
   * @return the current value (value >= 0.0)
   * @see #m_Scale
   */
  public double getScale() {
    return m_Scale;
  }

  /**
   * Sets the scale.
   *
   * @param value the new value (value >= 0.0)
   * @see #m_Scale
   */
  public void setScale(double value) {
    if (value >= 0.0) {
      m_Scale = value;
    }
  }

  /**
   * Returns the help string for scale.
   *
   * @return the help string
   * @see #m_Scale
   */
  public String scaleTipText() {
    return "The scale; value >= 0.0.";
  }

  /**
   * The default value for offset.
   *
   * @return the default value
   * @see #m_Offset
   */
  protected double getDefaultOffset() {
    return 0.0;
  }

  /**
   * Returns the offset value.
   *
   * @return the current value
   * @see #m_Offset
   */
  public double getOffset() {
    return m_Offset;
  }

  /**
   * Sets the offset value.
   *
   * @param value the new value
   * @see #m_Offset
   */
  public void setOffset(double value) {
    m_Offset = value;
  }

  /**
   * Returns the help string for offset.
   *
   * @return the help string
   * @see #m_Offset
   */
  public String offsetTipText() {
    return "The offset value.";
  }
}
