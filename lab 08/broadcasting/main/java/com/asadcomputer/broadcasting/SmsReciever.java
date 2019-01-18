package com.asadcomputer.broadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Message Received" , Toast.LENGTH_LONG ).show();
/*
        Bundle bundle=intent.getExtras();

        if (bundle != null){
            Object[] pdus= (Object[]) bundle.get("pdu");
            String SenderNumber=null;
            for (int i=0; i< pdus.length;i++){
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdus[i]);

                 SenderNumber=sms.getOriginatingAddress();

                String message=sms.getDisplayMessageBody();

                Toast.makeText(context, "From: " +SenderNumber +"message "+message , Toast.LENGTH_LONG ).show();
            }

          //  SmsManager smsManager=context.getSystemService(android.telephony.SmsManager);
           // smsManager.sendTextMessage(SenderNumber , null,"Sorry, I am kin of busy right now, I'll call you later",null );
        }
*/    }
}
