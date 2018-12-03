/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static javax.swing.UIManager.get;
    

/**
 *
 * @author ranas
 */
public class UnStaged {
    
    Branch branch;
    List<String> files;
    //CurrentStatus();
    public static boolean watch;
    
    
     public UnStaged()
    { }
  
    public void stageChange(String address) throws IOException
    {             
        try{
            
             StagingArea stgArea=new StagingArea();
             stgArea.setVisible(true);
             WatchService watchService = FileSystems.getDefault().newWatchService();		
		Path directory = Paths.get(address);
                files=new ArrayList<String>();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		
                int count=0;
                
		WatchKey watchKey = directory.register(watchService, 
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		
		while (watch==true) {
                   // System.out.println("Checking...");
                   // watchKey = watchService.poll(10, TimeUnit.MINUTES);
                   
			for (WatchEvent<?> event : watchKey.pollEvents()) {
				System.out.println(event.kind());
				Path file = directory.resolve((Path) event.context());
                                System.out.println(file + " was last modified at " + sdf.format(file.toFile().lastModified()));
                                if(event.kind().toString().equals("ENTRY_CREATE"))
                                {
                                    files.add(event.kind()+" -> "+file.toString()+" "+sdf.format(file.toFile().lastModified())); 
                                    count++;
                                    break;                              
                                }     
                                if(event.kind().toString().equals("ENTRY_DELETE"))
                                {
                                    files.add(event.kind()+" -> "+file.toString());                                     
                                    break;
                              
                                }     
                                 if(event.kind().toString().equals("ENTRY_MODIFY")&& count==0)
                                {
                                    files.add(event.kind()+" -> "+file.toString()+" "+sdf.format(file.toFile().lastModified()));                                 
                                    break;                    
                                }    
                                 count=0;
			}
                       // watchKey.reset();
                       Thread.sleep(1000);
                        stgArea.UnstageArea.setText(null);
                        for(String s: files)
                        {
                            stgArea.UnstageArea.append(s +"\n");
                            //u.stageArea.append(s +"\n");
                        }
		}
                stgArea.UnstageArea.setText(null);
                        for(String s: files)
                        {
                            //u.UnstageArea.append(s +"\n");
                            stgArea.stageArea.append(s +"\n");
                        }
}       
        catch (Exception e)
        {
            System.out.println("Something Went Wrong");
        }     
}

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public Branch getBranch() {
        return branch;
    }

    public List<String> getFiles() {
        return files;
    }
}
