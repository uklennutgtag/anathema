package net.sf.anathema.hero.framework.perspective;

import net.sf.anathema.character.main.template.HeroTemplate;
import net.sf.anathema.framework.persistence.RepositoryItemPersister;
import net.sf.anathema.framework.presenter.action.IItemCreator;
import net.sf.anathema.character.main.framework.item.Item;
import net.sf.anathema.lib.exception.PersistenceException;

public class NewItemCreator implements IItemCreator {

  private RepositoryItemPersister persister;

  public NewItemCreator(RepositoryItemPersister persister) {
    this.persister = persister;
  }

  @Override
  public Item createItem(HeroTemplate template) throws PersistenceException {
    Item item = persister.createNew(template);
    item.getItemData().getChangeManagement().setClean();
    return item;
  }
}