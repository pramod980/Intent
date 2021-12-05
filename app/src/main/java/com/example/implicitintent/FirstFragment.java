package com.example.implicitintent;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.implicitintent.databinding.FragmentFirstBinding;

import java.util.Date;

public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;
    private Button button;
    private EditText editText;
    private ImageView imageView;
    ActivityResultLauncher<String>photo;
    ActivityResultLauncher<Intent>activityResultLauncher;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentFirstBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        button=view.findViewById(R.id.button);
        editText=view.findViewById(R.id.editText);
        imageView=view.findViewById(R.id.imageView);
        photo=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
            public void onActivityResult(Uri result) {
                imageView.setImageURI(result);
          }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editText.getText().toString();
                Toast.makeText(getActivity(), "search button work", Toast.LENGTH_SHORT).show();
               // Toast.makeText(getActivity(), url, Toast.LENGTH_SHORT).show();



                // web implicit intent
               // Uri webpage = Uri.parse(url);
                // Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                // if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                 //   startActivity(intent);
                //}



                //Email intent
                //String [ ]addresses={"silwalpramod99@gmail.com","silwalpramod984@gmail.com"};
                //String subject="test";
               // String attachment="hello buddy how are you and what are you doing";
                //Intent intent = new Intent(Intent.ACTION_SEND);
                //intent.setType("*/*");
                //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                //intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                //intent.putExtra(Intent.EXTRA_TEXT,url);
                //if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                 //   startActivity(intent);
                //}


                //Alarm intent
                //String message=url;
                //int hour=05;
                //int minutes=00;

                //Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                 //       .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                 //       .putExtra(AlarmClock.EXTRA_HOUR, hour)
                 //       .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
                //if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                //    startActivity(intent);
                //}

                //Select image from gallery Intent
           photo.launch("image/*");



            }
        });
    }

@Override
    public void onDestroyView() {
    super.onDestroyView();
    binding = null;
}

}