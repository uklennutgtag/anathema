package net.sf.anathema.character.main.magic.parser;

import net.sf.anathema.character.main.magic.model.charm.ICharmData;

public interface ICharmEntryData {

  ICharmData getCoreData();

  String getName();

  int getPage();
}