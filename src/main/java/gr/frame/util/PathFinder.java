package gr.frame.util;

public class PathFinder {

	/**
	 * Gets the path from the package for the given Object. The dots are
	 * replaced with slashes.
	 * 
	 * @param object The object wich to determine the path.
	 * @return The Path from the package or null if the given object is null.
	 */
	public static String packagePath(Object object) {
		if (object == null){
			return null;
		}			
		String packagePath = object.getClass().getPackage().getName().replace(
				'.', '/')
				+ "/";
		return packagePath;
	}
}
