package io.github.astrapi69.chareditor.panels;

import de.alpharogroup.swing.base.BasePanel;
import de.alpharogroup.swing.utils.KeyStrokeExtensions;
import io.github.astrapi69.chareditor.actions.*;
import io.github.astrapi69.chareditor.viewmodel.ArmenianAlphabet;
import io.github.astrapi69.chareditor.ApplicationModelBean;
import io.github.astrapi69.chareditor.Messages;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainPanel extends BasePanel<ApplicationModelBean> {

    public static final String[] columnNames = {
            Messages.getString("TransformerJFrame.column"),
            Messages.getString("TransformerJFrame.column.latin"),
            Messages.getString("TransformerJFrame.column.htmlentitys"),
            "Representation"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    public static final String[] armenianColumnNames = {
            Messages.getString("TransformerJFrame.column.armenian"),
            Messages.getString("TransformerJFrame.column.latin"),
            Messages.getString("TransformerJFrame.column.htmlentitys"),
            "Representation"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    // JTextAreas and JTable
    JTextArea jtaPreview;

    JTextArea jtaHtmlEntitys;

    JTextArea jtaUnicode;

    JTextArea jtaInput;

    JTabbedPane jtpOutput;

    JPanel panelJTAHtmlEntitys;

    JPanel panelJTAUnicode;

    JTable jTableAlphabet;

    // JLabels
    JLabel labelInput;

    JLabel labelHtmlEntitys;

    JLabel labelUnicode;

    JLabel labelPreview;

    JLabel labelAlphabet;

    JLabel labelPlaceholder;

    // JScrollPane
    JScrollPane jscrollPaneTableAlphabet;

    JScrollPane jscrollPanejtaInput;

    JScrollPane jscrollPanejtaPreview;

    JScrollPane jscrollPanejtaHtmlEntitys;

    JScrollPane jscrollPanejtaUnicode;

    // Insets
    Insets oneInsent;

    Insets twoInsent;

    // Buttons
    JButton jbutInputTATranform;

    JButton jbutInputTACopyHtmlEntitys2Clipboard;

    JButton jbutInputTACopyIso_GreekChars_ToClipboard;

    JButton jbutInputTAClear;

    JButton jbutPreviewTATransform;

    JButton jbutHtmlEntitysTATransform;

    JButton jbutUnicodeTATransform;

    public MainPanel() {
    }

    @Override
    protected void onInitializeComponents()
    {
        createTransformPanel();
    }

    private void createTransformPanel() {
        createAllJLabels();
        createJTable();
        createAllJTextAreas();
        createAllJscrollPanes();
        createAllButtons();
        createAllInsets();
        createJPanels();
        createJTabbedPane();
        createLayout();
    }

    private JPanel newLabelWithButtonPanel(JLabel label, JButton button) {
        JPanel panel = new JPanel();
        BoxLayout boxLayoutHtmlEntitys = new BoxLayout(
                panel, BoxLayout.X_AXIS);
        panel.setLayout(boxLayoutHtmlEntitys);
        panel.add(label);
        panel.add(button);
        return panel;
    }

    private JPanel newPanelWithScrollPane(JPanel labelWithButtonPanel, JScrollPane jscrollPane) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(labelWithButtonPanel, BorderLayout.NORTH);
        panel.add(jscrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void createJPanels() {
        panelJTAHtmlEntitys = newPanelWithScrollPane(
                newLabelWithButtonPanel(labelHtmlEntitys, jbutHtmlEntitysTATransform), jscrollPanejtaHtmlEntitys);

        panelJTAUnicode = newPanelWithScrollPane(
                newLabelWithButtonPanel(labelUnicode, jbutUnicodeTATransform), jscrollPanejtaUnicode);
    }

    private void createJTabbedPane() {
        jtpOutput = new JTabbedPane();
        jtpOutput
                .addTab(
                        Messages.getString("TransformerJFrame.htmlentitys"), panelJTAHtmlEntitys); //$NON-NLS-1$
        jtpOutput
                .addTab(
                        Messages.getString("TransformerJFrame.unicode"), panelJTAUnicode); //$NON-NLS-1$
    }

    private void createAllInsets() {
        oneInsent = new Insets(1, 1, 1, 1);
        twoInsent = new Insets(2, 2, 2, 2);
    }

    private void createLayout() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(labelAlphabet, gbc);
        this.add(labelAlphabet);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(labelPlaceholder, gbc);
        this.add(labelPlaceholder);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = twoInsent;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(labelPreview, gbc);
        this.add(labelPreview);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = twoInsent;
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(jbutPreviewTATransform, gbc);
        this.add(jbutPreviewTATransform);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = twoInsent;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(jbutInputTACopyIso_GreekChars_ToClipboard, gbc);
        this.add(jbutInputTACopyIso_GreekChars_ToClipboard);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = twoInsent;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 2;
        gbc.ipady = 1;
        gbl.setConstraints(jscrollPaneTableAlphabet, gbc);
        this.add(jscrollPaneTableAlphabet);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = twoInsent;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 12;
        gbc.gridheight = 3;
        gbc.weighty = 100;
        gbc.weightx = 100;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(jscrollPanejtaPreview, gbc);
        this.add(jscrollPanejtaPreview);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = twoInsent;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(labelInput, gbc);
        this.add(labelInput);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = twoInsent;
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(jbutInputTATranform, gbc);
        this.add(jbutInputTATranform);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = twoInsent;
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(jbutInputTACopyHtmlEntitys2Clipboard, gbc);
        this.add(jbutInputTACopyHtmlEntitys2Clipboard);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = twoInsent;
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(jbutInputTAClear, gbc);
        this.add(jbutInputTAClear);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = twoInsent;
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 12;
        gbc.gridheight = 2;
        gbc.weighty = 100;
        gbc.weightx = 100;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbl.setConstraints(jscrollPanejtaInput, gbc);
        this.add(jscrollPanejtaInput);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = twoInsent;
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 12;
        gbc.gridheight = 2;
        gbc.weighty = 100;
        gbc.weightx = 100;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(jtpOutput, gbc);
        this.add(jtpOutput);
    }

    private void createAllButtons() {
        // Buttons
        jbutPreviewTATransform = new JButton(Messages
                .getString("TransformerJFrame.button.transform.chars")); //$NON-NLS-1$
        jbutPreviewTATransform.setToolTipText(Messages
                .getString("TransformerJFrame.7")); //$NON-NLS-1$
        jbutPreviewTATransform.addActionListener(new PreviewTATransformAction("PreviewTATransformAction"));
        jbutInputTATranform = new JButton(Messages
                .getString("TransformerJFrame.button.transform.latinchars")); //$NON-NLS-1$
        jbutInputTATranform.setToolTipText(Messages
                .getString("TransformerJFrame.9")); //$NON-NLS-1$
        jbutInputTATranform.addActionListener(new InputTATranformAction("InputTATranformAction"));
        jbutInputTACopyHtmlEntitys2Clipboard = new JButton(
                Messages
                        .getString("TransformerJFrame.button.copy.htmlentitys.to.clipboard")); //$NON-NLS-1$
        jbutInputTACopyHtmlEntitys2Clipboard
                .setToolTipText(Messages
                        .getString("TransformerJFrame.button.copy.htmlentitys.to.clipboard.tooltip")); //$NON-NLS-1$
        jbutInputTACopyHtmlEntitys2Clipboard.addActionListener(new InputTACopyHtmlEntitys2ClipboardAction("InputTACopyHtmlEntitys2ClipboardAction"));
        jbutInputTAClear = new JButton(Messages
                .getString("TransformerJFrame.button.clear")); //$NON-NLS-1$
        jbutInputTAClear.setToolTipText(Messages
                .getString("TransformerJFrame.button.clear.tooltip")); //$NON-NLS-1$
        jbutInputTAClear.addActionListener(new InputTAClearAction("InputTAClearAction"));

        jbutHtmlEntitysTATransform = new JButton(Messages
                .getString("TransformerJFrame.button.transform.htmlentitys")); //$NON-NLS-1$
        jbutHtmlEntitysTATransform
                .setToolTipText(Messages
                        .getString("TransformerJFrame.button.transform.htmlentitys.tooltip")); //$NON-NLS-1$
        jbutHtmlEntitysTATransform.addActionListener(new HtmlEntitysTATransformAction("HtmlEntitysTATransformAction"));

        jbutUnicodeTATransform = new JButton(Messages
                .getString("TransformerJFrame.button.transform.unicode")); //$NON-NLS-1$
        jbutUnicodeTATransform
                .setToolTipText(Messages
                        .getString("TransformerJFrame.button.transform.unicode.tooltip")); //$NON-NLS-1$
        jbutUnicodeTATransform.addActionListener(new UnicodeTATransformAction("UnicodeTATransformAction"));

        jbutInputTACopyIso_GreekChars_ToClipboard = new JButton(Messages
                .getString("TransformerJFrame.button.transform.chars.to.clipboard"));
        jbutInputTACopyIso_GreekChars_ToClipboard.setToolTipText(Messages
                .getString("TransformerJFrame.button.transform.chars.to.clipboard.tooltip"));
        String acInputTACopyIso_GreekChars_ToClipboardAction = "InputTACopyIso_GreekChars_ToClipboardAction";
        InputTACopyIso_GreekChars_ToClipboardAction inputTACopyIso_GreekChars_ToClipboardAction =
                new InputTACopyIso_GreekChars_ToClipboardAction(acInputTACopyIso_GreekChars_ToClipboardAction);
        jbutInputTACopyIso_GreekChars_ToClipboard.addActionListener(inputTACopyIso_GreekChars_ToClipboardAction);

        KeyStrokeExtensions.addShortcutToComponent(jbutInputTACopyIso_GreekChars_ToClipboard, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK
                + KeyEvent.ALT_MASK), acInputTACopyIso_GreekChars_ToClipboardAction, inputTACopyIso_GreekChars_ToClipboardAction);


    }

    private void createAllJscrollPanes() {
        // JscrollPanes
        jscrollPaneTableAlphabet = new JScrollPane(jTableAlphabet);
        jscrollPanejtaPreview = new JScrollPane(jtaPreview);
        jscrollPanejtaHtmlEntitys = new JScrollPane(jtaHtmlEntitys);
        jscrollPanejtaUnicode = new JScrollPane(jtaUnicode);
        jscrollPanejtaInput = new JScrollPane(jtaInput);
    }

    private void createAllJTextAreas() {
        // JTextArea preview:
        jtaPreview = new JTextArea(5, 50);
        jtaPreview.setLineWrap(true);
        jtaPreview.setWrapStyleWord(true);
        jtaPreview.setEditable(true);

        // JTextArea Unicode:
        jtaUnicode = new JTextArea(5, 50);
        jtaUnicode.setLineWrap(true);
        jtaUnicode.setWrapStyleWord(true);
        jtaUnicode.setEditable(true);

        // JTextArea HTML entitys:
        jtaHtmlEntitys = new JTextArea(5, 50);
        jtaHtmlEntitys.setLineWrap(true);
        jtaHtmlEntitys.setWrapStyleWord(true);
        jtaHtmlEntitys.setEditable(true);

        // JTextArea Input:
        jtaInput = new JTextArea(5, 50);
        jtaInput.setLineWrap(true);
        jtaInput.setWrapStyleWord(true);
        jtaInput.setEditable(true);
    }

    private void createJTable() {
        jTableAlphabet = new JTable(ArmenianAlphabet.alphabet, armenianColumnNames);
    }

    private void createAllJLabels() {
        labelAlphabet = new JLabel(Messages
                .getString("TransformerJFrame.label.alphabet.table")); //$NON-NLS-1$
        labelPlaceholder = new JLabel(Messages
                .getString("TransformerJFrame.label.placeholder")); //$NON-NLS-1$
        labelInput = new JLabel(Messages
                .getString("TransformerJFrame.label.input.latin")); //$NON-NLS-1$
        labelHtmlEntitys = new JLabel(Messages
                .getString("TransformerJFrame.label.output.htmlentitys")); //$NON-NLS-1$
        labelUnicode = new JLabel(Messages
                .getString("TransformerJFrame.label.output.unicode")); //$NON-NLS-1$
        labelPreview = new JLabel(Messages
                .getString("TransformerJFrame.label.preview")); //$NON-NLS-1$
    }

}
