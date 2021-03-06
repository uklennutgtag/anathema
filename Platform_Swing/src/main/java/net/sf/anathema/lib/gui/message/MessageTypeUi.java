package net.sf.anathema.lib.gui.message;

import net.sf.anathema.lib.gui.icon.EmptyIcon;
import net.sf.anathema.lib.gui.icon.ImageProvider;
import net.sf.anathema.lib.message.IMessageTypeVisitor;
import net.sf.anathema.lib.message.MessageType;

import javax.swing.Icon;

public class MessageTypeUi extends AbstractMessageTypeUi {

  public static final Icon normalIcon = EmptyIcon.DEFAULT_ICON;
  private static final ImageProvider imageProvider = new ImageProvider();
  private static final MessageTypeImagePaths imagePaths = new MessageTypeImagePaths();
  public static final Icon errorIcon = imageProvider.getImageIcon(imagePaths.getIconPath(MessageType.ERROR));
  public static final Icon warningIcon = imageProvider.getImageIcon(imagePaths.getIconPath(MessageType.WARNING));
  public static final Icon infoIcon = imageProvider.getImageIcon(imagePaths.getIconPath(MessageType.INFORMATION));
  public static final Icon questionIcon = imageProvider.getImageIcon(imagePaths.getIconPath(MessageType.QUESTION));

  private static MessageTypeUi instance = new MessageTypeUi();

  @Override
  public Icon getIcon(MessageType type) {
    final Icon[] icon = new Icon[1];
    type.accept(new IMessageTypeVisitor() {
      @Override
      public void visitError(MessageType visitedType) {
        icon[0] = errorIcon;
      }

      @Override
      public void visitNormal(MessageType visitedType) {
        icon[0] = normalIcon;
      }

      @Override
      public void visitWarning(MessageType visitedType) {
        icon[0] = warningIcon;
      }

      @Override
      public void visitInformation(MessageType visitedType) {
        icon[0] = infoIcon;
      }

      @Override
      public void visitQuestion(MessageType visitedType) {
        icon[0] = questionIcon;
      }
    });
    return icon[0];
  }

  public static MessageTypeUi getInstance() {
    return instance;
  }
}