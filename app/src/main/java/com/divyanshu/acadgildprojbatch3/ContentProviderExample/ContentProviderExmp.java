package com.divyanshu.acadgildprojbatch3.ContentProviderExample;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Divyanshu on 27-07-2016.
 */
public class ContentProviderExmp extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback{

    android.support.v4.widget.SimpleCursorAdapter mAdapter;
    MatrixCursor mMatrixCursor;
    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentprovider_list);

        mMatrixCursor = new MatrixCursor(new String[]{"_id","name","photo","details"});


        mAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.activity_contentprovider_view,null,
                new String[]{"name","photo","details"},
                new int[]{R.id.tv_nameTxt,R.id.iv_photo, R.id.tv_details},0);

        ListView listContacts = (ListView)findViewById(R.id.list_contacts);
        listContacts.setAdapter(mAdapter);
        askForPermissions();
//        ListViewContactsLoader listViewContactsLoader = new ListViewContactsLoader();
//        listViewContactsLoader.execute();
    }


    private class ListViewContactsLoader extends AsyncTask<Void,Void,Cursor>{


        @Override
        protected Cursor doInBackground(Void... params) {

            Uri contactsUri = ContactsContract.Contacts.CONTENT_URI;

            Cursor contactsCursor = getContentResolver().query(contactsUri,null,null,null,ContactsContract.Contacts.DISPLAY_NAME+" ASC ");

            if(contactsCursor.moveToNext()){
                do{
                    long contactId = contactsCursor.getLong(contactsCursor.getColumnIndex("_ID"));

                    Uri dataUri = ContactsContract.Data.CONTENT_URI;

                    Cursor dataCursor = getContentResolver().query(dataUri,null,ContactsContract.Data.CONTACT_ID+"="+contactId,null,null);

                    String displayName="";
                    String nickName="";
                    String homePhone="";
                    String mobilePhone="";
                    String workPhone="";
                    String photoPath="" + R.drawable.ic_add_calendar;
                    byte[] photoByte=null;
                    String homeEmail="";
                    String workEmail="";
                    String companyName="";
                    String title="";

                    if(dataCursor.moveToFirst()){

                        displayName = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                        do{

                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE));
                            nickName = dataCursor.getString(dataCursor.getColumnIndex("data1"));

                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)){
                                switch (dataCursor.getInt(dataCursor.getColumnIndex("data2"))){
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                                        homePhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                        break;

                                    case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                        mobilePhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                        break;
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                                        workPhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                        break;
                                }
                            }


                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)){
                                companyName = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                title = dataCursor.getString(dataCursor.getColumnIndex("data4"));
                            }

                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE)){
                                photoByte = dataCursor.getBlob(dataCursor.getColumnIndex("data15"));

                                if(photoByte != null){
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(photoByte,0,photoByte.length);
                                    File cacheDirectory = getBaseContext().getCacheDir();

                                    File tempFile = new File(cacheDirectory.getPath()+"/wpta_"+contactId+".png");

                                    try{
                                        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
                                        bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
                                        fileOutputStream.flush();

                                        fileOutputStream.close();
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }

                                    photoPath = tempFile.getPath();
                                }
                            }

                        }while(dataCursor.moveToNext());

                        String details="";

                        if(homePhone !=null && !homePhone.equals(""))
                            details="Homephone :"+homePhone+"\n";

                        if(mobilePhone !=null && !mobilePhone.equals(""))
                            details="mobilePhone :"+mobilePhone+"\n";
                        if(workPhone !=null && !workPhone.equals(""))
                            details="workPhone :"+workPhone+"\n";
                        if(nickName !=null && !nickName.equals(""))
                            details="nickName :"+nickName+"\n";
                        if(homeEmail !=null && !homeEmail.equals(""))
                            details="homeEmail :"+homeEmail+"\n";
                        if(workEmail !=null && !workEmail.equals(""))
                            details="workEmail :"+workEmail+"\n";
                        if(companyName !=null && !companyName.equals(""))
                            details="companyName :"+companyName+"\n";
                        if(title !=null && !title.equals(""))
                            details="title :"+title+"\n";


                        mMatrixCursor.addRow(new Object[]{Long.toString(contactId),displayName,photoPath,details});
                    }
                }while (contactsCursor.moveToNext());
            }

            return mMatrixCursor;
        }

        @Override
        protected void onPostExecute(Cursor result) {
            super.onPostExecute(result);

            mAdapter.swapCursor(result);
        }
    }

    private void askForPermissions() {
        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, Manifest.permission.READ_CONTACTS))
            permissionsNeeded.add("READ_CONTACTS");
        if (!addPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE))
            permissionsNeeded.add("WRITE_EXTERNAL_STORAGE");

        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                String message = "You need to grant access to " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
//                showMessageOKCancel(message,
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
//                                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
//                            }
//                        });
                return;
            }
            requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            return;
        }

        ListViewContactsLoader listViewContactsLoader = new ListViewContactsLoader();
        listViewContactsLoader.execute();
    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (ContextCompat.checkSelfPermission(ContentProviderExmp.this, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

//

        if (requestCode == REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS) {
            Map<String, Integer> perms = new HashMap<String, Integer>();
            // Initial
            perms.put(Manifest.permission.READ_CONTACTS, PackageManager.PERMISSION_GRANTED);
            perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
            // Fill with results
            for (int i = 0; i < permissions.length; i++)
                perms.put(permissions[i], grantResults[i]);
            // Check for ACCESS_FINE_LOCATION
            if (perms.get(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
                    && perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // All Permissions Granted
                ListViewContactsLoader listViewContactsLoader = new ListViewContactsLoader();
                listViewContactsLoader.execute();
            } else {
                // Permission Denied
                Toast.makeText(ContentProviderExmp.this, "Some Permission is Denied", Toast.LENGTH_SHORT)
                        .show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }




}
