public class ChangeDirectory {
    public static void main(String[] as)
    {
        String currentPath = "/a/b/c/d";
        Path path = new Path(currentPath);
        path.cd("../x");

        System.out.println(".......................");

        path.cd("/y/z");
    }


}

class Path {
    String currentPath;

    public Path(String value)
    {
        currentPath = value;
    }

    public void cd(String value)
    {
        System.out.println("Original Path : " + currentPath);

        if (value.startsWith(".."))
        {
            int lastIndex = currentPath.lastIndexOf("/");
            currentPath = currentPath.substring(0,6);

            if (value.length() > 2)
            {
                String extendedPath = value.substring(2,value.length());
                currentPath = currentPath.concat(extendedPath);
            }

            System.out.println("New Path : " + currentPath);
        }

        else if (value.startsWith("/"))
        {
            currentPath = currentPath.concat(value);
            System.out.println("New Path : " + currentPath);
        }
    }
}