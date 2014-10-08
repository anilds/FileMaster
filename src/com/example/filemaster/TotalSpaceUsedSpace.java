package com.example.filemaster;

import android.os.Environment;
import android.os.StatFs;
import android.widget.Toast;

public class TotalSpaceUsedSpace  {
	
	public static void remainingLocalStorage()
	{
	StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
	stat.restat(Environment.getDataDirectory().getPath());
	long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getAvailableBlocks();
	Toast.makeText(null, "Available bytes"+bytesAvailable, Toast.LENGTH_SHORT);
	//return bytesAvailable;
	}



}
