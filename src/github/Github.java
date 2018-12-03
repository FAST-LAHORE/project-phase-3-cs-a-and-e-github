/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.io.IOException;

/**
 *
 * @author ranas
 */
public class Github {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        
        Branch b=new Branch();
        b.showUnstage();
        
       // b.stageChanged();
    }
    
}
