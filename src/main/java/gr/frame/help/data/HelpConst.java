package gr.frame.help.data;

import gr.frame.Messages;

public abstract class HelpConst {
    private static final String SINGLECR = Messages.getString("helpconstants.carriage.return"); //$NON-NLS-1$
	private static final String DOUBLECR = SINGLECR+SINGLECR;
	public static String helpText = Messages.getString("helpconstants.introduction.title") //$NON-NLS-1$
        +DOUBLECR
        +Messages.getString("helpconstants.introduction.text") //$NON-NLS-1$
        +DOUBLECR
        +Messages.getString("helpconstants.operation.title") //$NON-NLS-1$
        +DOUBLECR
        +Messages.getString("helpconstants.operation.text") //$NON-NLS-1$
        +DOUBLECR
        +Messages.getString("helpconstants.menu.title") //$NON-NLS-1$
        +DOUBLECR
        +Messages.getString("helpconstants.menu.text") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.new") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.open") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.save") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.saveas") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.exit") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.edit") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.edit.lookandfeel") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.edit.lookandfeel.metal") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.edit.lookandfeel.motiv") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.edit.lookandfeel.windows") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.help") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.help.content") //$NON-NLS-1$
        +SINGLECR
        +Messages.getString("helpconstants.menu.item.help.info") //$NON-NLS-1$
        +SINGLECR; //$NON-NLS-1$
      
}
