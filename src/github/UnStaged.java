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

/**
 *
 * @author ranas
 */
public class UnStaged {
    
    Branch branch;
    List<String> files;
    //CurrentStatus();
    
    
    
     public UnStaged()
    { }
    
    public void stageChange(String address) throws IOException
    {             
        try{
         WatchService watchService = FileSystems.getDefault().newWatchService();
		
		Path directory = Paths.get(address);
                files=new ArrayList<String>();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		
	
                
		WatchKey watchKey = directory.register(watchService, 
				StandardWatchEventKinds.ENTRY_CREATE, 
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		
		while (true) {
                    watchKey = watchService.poll(10, TimeUnit.MINUTES);
			for (WatchEvent<?> event : watchKey.pollEvents()) {
				System.out.println(event.kind());
				Path file = directory.resolve((Path) event.context());
                                files.add(file.toString());
				System.out.println(file + " was last modified at " + sdf.format(file.toFile().lastModified()));
			}
                        watchKey.reset();
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
