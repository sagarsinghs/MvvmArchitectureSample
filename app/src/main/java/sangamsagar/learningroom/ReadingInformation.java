package sangamsagar.learningroom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ReadingInformation extends Fragment {
    TextView title,heading;
    Button extract;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.reading_information, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


/*
        title = (TextView) view.findViewById(R.id.title);
        heading =(TextView) view.findViewById(R.id.heading);
        extract = (Button) view.findViewById(R.id.extract);

       // List<ModelClass> users =MvvmActivity.myAppDatabase.myDataAccessObject().getDetails();

        String info =" ";
        for (ModelClass users1: users)
        {
            int id= users1.getId();

            String name=  users1.getTitle();
           // String marks =  users1.getHeading();

          //  info = info + "\n\n" + id+ "\n\n" + name +"\n\n" + marks;
          //  Log.d("ReadinguserFragments",info);

            title .setText(name);
          //  heading.setText(marks);*/
        }

    }
/*}*/
