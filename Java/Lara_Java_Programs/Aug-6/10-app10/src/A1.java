class A1
{
    public static void main(String[] args) 
    {
        int i;
        for(i = 0, System.out.println("INITIALIZER");
            i < 3;
            i++, System.out.println("INCREMENT"))
        {
                System.out.println("BODY");
        }
    }
}