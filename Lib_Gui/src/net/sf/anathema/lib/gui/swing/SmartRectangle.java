package net.sf.anathema.lib.gui.swing;

import com.google.common.base.Preconditions;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class SmartRectangle extends Rectangle {

  public SmartRectangle(final Rectangle rect) {
    this(rect.x, rect.y, rect.width, rect.height);
  }

  public SmartRectangle(final Point position, final Dimension size) {
    this(position.x, position.y, size.width, size.height);
  }

  public SmartRectangle(final int ulx, final int uly, final int width, final int height) {
    super(ulx, uly, width, height);
    Preconditions.checkArgument(width >= 0, "Width <0 : '" + width + "'");
    Preconditions.checkArgument(height >= 0, "Height <0 : '" + height + "'");
  }

  public int getUlx() {
    return x;
  }

  public int getUly() {
    return y;
  }

  public int getLrx() {
    return x + width;
  }

  public int getLry() {
    return y + height;
  }

  /**
   * Move the box
   *
   * @param dx x coordinate of the moving vector
   * @param dy y coordinate of the moving vectot
   */
  @Override
  public void setLocation(final int dx, final int dy) {
    x += dx;
    y += dy;
  }

  public Point getCenter() {
    return new Point((getLrx() + getUlx()) / 2, (getLry() + getUly()) / 2);
  }
}