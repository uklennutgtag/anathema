package net.sf.anathema.hero.concept.display.description.view;

import net.sf.anathema.character.generic.type.ICharacterType;
import net.sf.anathema.character.platform.RegisteredCharacterView;
import net.sf.anathema.character.view.SubViewFactory;
import net.sf.anathema.hero.concept.display.description.presenter.CharacterDescriptionView;

@RegisteredCharacterView(CharacterDescriptionView.class)
public class DescriptionViewFactory implements SubViewFactory {
  @SuppressWarnings("unchecked")
  @Override
  public <T> T create(ICharacterType type) {
    FxDescriptionView view = new FxDescriptionView();
    return (T) new BridgingDescriptionView(view);
  }
}