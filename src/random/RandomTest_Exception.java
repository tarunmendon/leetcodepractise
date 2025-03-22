package src.random;

public class RandomTest_Exception {
public static void main(String[] args)
{
    try
    {
        throw new RuntimeException("Testing random exception");
    }catch(Throwable e)
    {
        System.out.println("Caught exception:"+e.getMessage());
    }
    /*Compile time error below*/
  /*  catch(Exception er)
    {

    }
*/
}
}
