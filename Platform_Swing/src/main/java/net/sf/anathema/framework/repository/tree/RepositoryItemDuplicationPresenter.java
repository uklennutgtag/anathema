package net.sf.anathema.framework.repository.tree;

import net.sf.anathema.framework.environment.Resources;
import net.sf.anathema.framework.fx.ExceptionIndicator;
import net.sf.anathema.framework.item.IItemType;
import net.sf.anathema.framework.messaging.IMessaging;
import net.sf.anathema.framework.repository.RepositoryException;
import net.sf.anathema.framework.repository.access.RepositoryFileAccess;
import net.sf.anathema.framework.view.PrintNameFile;
import net.sf.anathema.initialization.FxApplicationFrame;
import net.sf.anathema.lib.control.ChangeListener;
import net.sf.anathema.lib.gui.action.SmartAction;
import net.sf.anathema.lib.message.Message;
import net.sf.anathema.lib.message.MessageType;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class RepositoryItemDuplicationPresenter {

  private final Resources resources;
  private final RepositoryTreeModel model;
  private final RepositoryTreeView view;
  private final IMessaging messaging;

  public RepositoryItemDuplicationPresenter(Resources resources, RepositoryTreeModel repositoryTreeModel,
                                            RepositoryTreeView treeView, IMessaging messaging) {
    this.resources = resources;
    this.model = repositoryTreeModel;
    this.view = treeView;
    this.messaging = messaging;
  }

  public void initPresentation() {
    final SmartAction action = new SmartAction(resources.getString("AnathemaCore.Tools.RepositoryView.DuplicateName"),
            new FileUi().getDuplicateFileIcon()) {

      @Override
      protected void execute(Component parentComponent) {
        try {
          PrintNameFile[] printNameFiles = model.getPrintNameFilesInSelection();
          for (PrintNameFile printNameFile : printNameFiles) {
            String id = printNameFile.getRepositoryId();
            IItemType type = printNameFile.getItemType();
            RepositoryFileAccess readAccess = model.getFileAccess(printNameFile);
            String mainFilePath = model.getMainFilePath(type, id);
            RepositoryImportHandler handler = new RepositoryImportHandler(model, type, id);
            for (File file : readAccess.getFiles()) {
              InputStream inputStream = readAccess.openInputStream(file);
              handler.importStream(mainFilePath, inputStream, file.getPath());
              inputStream.close();
            }
            model.refreshItem(type, handler.getNewId());
            messaging.addMessage("AnathemaCore.Tools.RepositoryView.DuplicateDoneMessage", MessageType.INFORMATION);
          }
        } catch (RepositoryException e) {
          Message message = new Message(resources.getString("AnathemaCore.Tools.RepositoryView.RepositoryError"), e);
          ExceptionIndicator.indicate(resources, FxApplicationFrame.getOwner(), message);
        } catch (IOException e) {
          Message message = new Message(resources.getString("AnathemaCore.Tools.RepositoryView.FileError"), e);
          ExceptionIndicator.indicate(resources, FxApplicationFrame.getOwner(), message);
        }
      }
    };
    action.setToolTipText(resources.getString("AnathemaCore.Tools.RepositoryView.DuplicateToolTip"));
    view.addActionButton(action);
    model.addTreeSelectionChangeListener(new ChangeListener() {
      @Override
      public void changeOccurred() {
        action.setEnabled(model.getPrintNameFilesInSelection().length == 1);
      }
    });
    action.setEnabled(false);
  }
}
