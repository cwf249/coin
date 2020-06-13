import java.io.IOException;

public class BIO
{
  private static final int EOF  = -1;              
  private static final int NONE = -2;            
  private static int  haveNextChar  = NONE;       
  private static boolean eofDetected = false;   

  private static int getCharX()
  {
    try                                            
    {
      int c = System.in.read();                     
      if ( c == '\r' )                          
        return getCharX();
      return c;                                 
    } 
    catch( IOException exp )                   
    {
      System.out.println();                  
      System.out.println("**** Error ****\n" +
             exp.getMessage() + "\n" +
             "Detected on input -- EXIT ****" );
      System.exit(-1);                          
    }
    return EOF;                                    
  }
   
  private static int getChar()
  {
    int ch;                                    
    if ( eofDetected )                         
    {                                             
      System.out.println();                    
      System.out.println("**** END OF FILE " +
            "detected on input -- EXIT ****" );
      System.exit(-1);                         
    }
    if ( haveNextChar == NONE )                 
    {
      ch = getCharX();                             
    } else {
      ch = haveNextChar;                           
      haveNextChar = NONE;                        
    }
    if ( ch == EOF )
     eofDetected = true;                        
    return ch;                                      
  }

  public static boolean eof()                      
  {
    if ( eofDetected ) return true;
    if ( haveNextChar == NONE )                    
    {                                            
      haveNextChar = getCharX();                   
    }
    return haveNextChar == EOF;                  
  }

  private static String getLineBASE()
  {
    String line = "";                              
    int ch = getChar();                          

    while( ch != '\n' )                            
    {
      if ( ch == EOF )
      {
        return line;                            
      }
        line = line + (char) ch;                   
      ch = getChar();                              
    }
    return line;                                    
  }

  private static String getLine()
  {
    String line = getLineBASE();                
    return line;
  }

  public static String getString()
  {
    String line = getLine();                       
    return line;
  }
 
  public static double getDouble()
  {
    String res = getLine();                        
    double value = 0.0;                           
    try
    {
      value = Double.parseDouble( res.trim() );     
    }
    catch ( NumberFormatException ex )              
    {                                               
    }
    return value;                                  
  }

  public static int getInt()
  {
    String res = getLine();                         
    int value = 0;                              
    try
    {
      value = Integer.parseInt( res.trim() );       
    }
    catch ( NumberFormatException ex )              
    {                                           
    }
    return value;                               
  }
}