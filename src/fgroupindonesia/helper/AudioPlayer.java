// AudioPlayer memanfaatkan htmlunit 
// untuk mendapatkan address 
// google translate audio indonesia to indonesia
// https://translate.google.com/?sl=en&tl=id&text=selamat%20datang%20budi&op=translate
package fgroupindonesia.helper;

/**
 *
 * @author fgroupindonesia
 */
public class AudioPlayer {
    
    enum Mode {
        OFFLINE, 
        ONLINE
    }
    
    Mode opsi;
    
    public void setMode(Mode opsina){
        opsi = opsina;
    }
    
    public void readWelcome(String username){
     
        if(opsi != Mode.OFFLINE){
        // pass the url call
     
        // read the file
        
        } else {
            
        }
               
        
        
    }
    
}
