package com.example.user.curiositybleproject;

import android.content.Context;

import com.example.user.curiositybleproject.Interfaces.IAccCaptor;
import com.example.user.curiositybleproject.Interfaces.IDataNotify;

import java.util.Random;

/**
 * Created by jordan on 28/11/17.
 */

public class AccCaptor implements IAccCaptor, Runnable{

    int mId = 0;
    IDataNotify mDataNotify;
    Thread mThread;
    Boolean mIsRunning = false;
    float mTab_Data = 0;

    //constructor
    public AccCaptor(IDataNotify dataNotify){

        Random rand = new Random();
        mId = rand.nextInt(5000) + 1;
        //mTab_Data = new int[]{0xFEB0,0x03C4,0x3a64,0x02c7,0x00da,0x0073,0xff3c,0xff2c,0xfe5a,0xf200, 0xf924,0x02ec,0x3a5c,0xfebb,0xfffa, 0x0080,0xff3c,0xff2c,0xfe5a,0xf220};
        mDataNotify = dataNotify;
        mIsRunning = true;
        mThread = new Thread(this);
        mThread.start();

    }

    @Override
    public void run() {
        int i = 0;
        while(mIsRunning)
        {
            if(i != 100)
            {
                mTab_Data = i;
                mDataNotify.dataNotify(mId, (int) mTab_Data);
                i++;
            }
            else
            {
                i = 0;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public float getAcc() {
        return mTab_Data;
    }

    @Override
    public int getId() {
        return mId;
    }

}
