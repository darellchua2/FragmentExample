package iss.workshop.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import iss.workshop.fragments.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class ListFragment extends Fragment {
    private IDetailFragment iDetailFragment;

    public interface IDetailFragment {
        void itemClicked (String content);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        iDetailFragment = (IDetailFragment) context;
    }

    private int itemId;
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutRoot = inflater.inflate(R.layout.fragment_list,
                container, false);

        return layoutRoot;
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view!=null ){
            DataItem item = DataService.getItem(itemId);
            TextView itemNumber = view.findViewById(R.id.item_number);
            itemNumber.setText(String.valueOf(item.getId()));

            itemNumber.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    TextView textView = (TextView) v;
                    iDetailFragment.itemClicked(
                            textView.getText().toString()
                    );
                }
            });

            TextView desc = view.findViewById(R.id.content);
            desc.setText(item.getDescription());

            desc.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    TextView textView = (TextView) v;
                    iDetailFragment.itemClicked(
                            textView.getText().toString()
                    );
                }
            });



        }
    }



}