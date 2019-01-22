
package inne;
 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.*;
 
 
public class OnlyNumberFormatter extends PlainDocument {
    private final int limit;
    
    public OnlyNumberFormatter(int limit) {
        super();
        this.limit = limit;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }

    @Override
    protected void insertUpdate(DefaultDocumentEvent chng, AttributeSet attr) {
        try {
            char newChar = this.getText(chng.getOffset(),1).charAt(0);
            if(!Character.isDigit(newChar)) {
                remove(chng.getOffset(),1);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(OnlyNumberFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}