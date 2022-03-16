package com.hackztalk.profilepic.Fragments;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hackztalk.profilepic.Adapters.Saved_Adapter;
import com.hackztalk.profilepic.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link savedfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class savedfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public savedfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment savedfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static savedfragment newInstance(String param1, String param2) {
        savedfragment fragment = new savedfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_savedfragment, container, false);


        ArrayList<Uri> imageuris = new ArrayList<>();


        String[] projection = new String[]{
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.SIZE,
                MediaStore.Images.Media.DATE_MODIFIED,
        };
        String selection = null;
        String selectionargs[] = null;
        String orderby = null;
        Uri contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = getContext().getContentResolver().query(contentUri, projection, selection, selectionargs, orderby);


        try {
            if (cursor != null) {


                cursor.moveToPosition(0);
                while (true) {

                    long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID));
                    Uri uriId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
                    imageuris.add(uriId);


                    if (!cursor.isLast())
                        cursor.moveToNext();

                    else
                        break;
                }
                RecyclerView rvSaved = v.findViewById(R.id.rvSaved);
                rvSaved.setLayoutManager(new GridLayoutManager(getContext(), 2));
                Saved_Adapter adapter = new Saved_Adapter(imageuris);
                rvSaved.setAdapter(adapter);


            }


        }catch (Exception e){

//            Toast.makeText(getContext(), "Empty..."+e.toString(), Toast.LENGTH_SHORT).show();
            TextView tvemp;
            tvemp = v.findViewById(R.id.tvemp);

            tvemp.setText("Nothing Saved Yet");
        }
        return v;
    }

}