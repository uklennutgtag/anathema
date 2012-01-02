package net.sf.anathema.character.db.reporting;

import net.sf.anathema.character.reporting.pdf.layout.simple.AbstractSecondEditionExaltPdfPartEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.general.box.IBoxContentEncoder;
import net.sf.anathema.lib.resources.IResources;

public class Simple2ndEditionDbPartEncoder extends AbstractSecondEditionExaltPdfPartEncoder {

  public Simple2ndEditionDbPartEncoder(IResources resources) {
    super(resources);
  }

  @Override
  public IBoxContentEncoder getGreatCurseEncoder() {
    return new Db2ndEditionGreatCurseEncoder();
  }

  @Override
  public IBoxContentEncoder getAnimaEncoder() {
    return new DbAnimaEncoderFactory(getResources()).createAnimaEncoder();
  }
}