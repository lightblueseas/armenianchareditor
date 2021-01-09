package gr.frame.filefilter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class GRCFilter extends FileFilter {
	
    private static final String DESCRIPTION = "grc Files(*.grc)";
	/**     */
    public static final String SUFFIX = "grc";

    public boolean accept(File f) {
        boolean accept = f.isDirectory();
        if (!accept){
            String suffix = getSuffix(f);
            if(suffix != null){
                accept = suffix.equals(SUFFIX);
            }
        }
        return accept;        
    }

    public String getDescription() {
        return DESCRIPTION;
    }
    
    public String getSuffix(File f) {
        String s = f.getPath(), suffix = null;
        int i = s.lastIndexOf('.');

        if(i > 0 &&  i < s.length() - 1)
            suffix = s.substring(i+1).toLowerCase();

        return suffix;
    }

}
