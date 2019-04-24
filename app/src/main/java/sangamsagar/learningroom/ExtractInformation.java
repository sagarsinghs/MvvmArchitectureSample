package sangamsagar.learningroom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExtractInformation extends Fragment {

/*
    TextView title,heading;
    Button extract;

    String title1,description1;
   // int i= 0;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    public static String URL_FOR_REGISTRATION;
    ModelClass modelClass;
    @Nullable*/
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.extract_information, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


      /*  extract = (Button) view.findViewById(R.id.extract);

        extract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  extracting_the_details();

                ModelClass modelClass = new ModelClass();

               // modelClass.setId(1);
                modelClass.setTitle("title111");
                modelClass.setHeading("description1111");

                MvvmActivity.myAppDatabase.myDataAccessObject().addDetails(modelClass);
                Toast.makeText(getContext(), "data added successfully", Toast.LENGTH_SHORT).show();

                Fragment fragment = new ReadingInformation();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }


            });
*/


    }

    public  void extracting_the_details()
    {
       /* URL_FOR_REGISTRATION ="https://newsapi.org/v2/everything?sources=al-jazeera-english&apiKey=dd58977a4b15400da37c91936335d8dd";
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(getContext());

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, URL_FOR_REGISTRATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("ResponseWeAreGetting",response);

                JSONObject j1 = null;
                try {
                    JSONObject jObj = new JSONObject(response.trim());
                    JSONArray jsonArray =   jObj.getJSONArray("articles");


                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jj = jsonArray.getJSONObject(i);
                        String author = jj.getString("author");
                         title1 = jj.getString("title");
                         description1 = jj.getString("description");
                        String published = jj.getString("publishedAt");
                        String content = jj.getString("content");
                        String url_image= jj.getString("urlToImage");
                        String url = jj.getString("url");
                       *//* modelClass = new ModelClass();
                        modelClass.setTitle(title1);
                        modelClass.setHeading(description1);

                        MvvmActivity.myAppDatabase.myDataAccessObject().addDetails(modelClass);
*//*
                       *//* title.setText(title1);
                        heading.setText(description1);*//*

                        break;

                    }

                }catch (JSONException e1) {
                    e1.printStackTrace();

                }


                //   Toast.makeText(getContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(),"You have got the error here", Toast.LENGTH_LONG).show();//display the response on screen

                Log.i("Findingtheerroe","Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);*/

    }

}
