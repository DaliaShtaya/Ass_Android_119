package com.example.ass_android_119;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ExploreActivity extends AppCompatActivity {

    private ListView eleme_list;
    private TextView detailTextView;

    // Sample array of elements (replace with your actual data)
    private String[] element = {"Hydrogen", "Helium", "Lithium", "Beryllium", "Boron"};

    // Sample array of descriptions (replace with your actual data)
    private String[] descriptions = {
            "Hydrogen is the simplest and most abundant element in the universe. It's also the lightest element, both in weight and in its atomic structure. In its pure form, hydrogen is a colorless, odorless, and tasteless gas. Each hydrogen atom has only one proton in its nucleus, and it typically has one electron orbiting around the nucleus. Hydrogen is essential for life and is found in many compounds like water (H2O) and organic molecules. It's also used in various industries, including fuel production and the manufacturing of chemicals like ammonia. Overall, hydrogen plays a fundamental role in the " +
                    "functioning of our universe and in various aspects of our daily lives.",
            "Helium, the second lightest element, is abundant in the universe but relatively rare on Earth. It's a colorless, odorless gas and chemically inert, making it useful for various applications, including filling balloons, airships, and welding. At low temperatures, it becomes a liquid with unique properties, such as superfluidity. Helium is vital in scientific and medical fields, such as cooling MRI magnets and deep-sea diving. However, its scarcity on Earth highlights the importance of conservation efforts due to its crucial role in numerous industries.",
            "Lithium, a lightweight metal, holds significant importance in various fields. Its unique properties, such as high energy density and excellent conductivity, make it indispensable in rechargeable lithium-ion batteries, powering everything from smartphones to electric vehicles. Beyond electronics, lithium compounds are used in medication to treat mood disorders like bipolar disorder. Additionally, lithium plays a crucial role in nuclear fusion research and as a coolant in certain types of reactors. Despite its versatility, the limited availability of lithium reserves emphasizes the need for sustainable extraction methods and recycling initiatives to meet growing demand..",
            "Beryllium, a rare and lightweight metal, possesses remarkable properties that make it valuable in various industries. Its strength, stiffness, and low density make it ideal for aerospace applications, where it's used in high-performance components such as aircraft structures and satellites. Its ability to dissipate heat efficiently also makes it essential in the manufacture of heat sinks for electronics. However, beryllium is toxic when inhaled as dust or fumes, posing health risks to workers involved in its mining, refining, and processing. Consequently, stringent safety measures are necessary to mitigate these risks. Despite its challenges, beryllium's unique combination of properties continues to ensure its importance in specialized technological applications..",
            "Boron, a versatile metalloid, exhibits unique properties that find application in various industries. Its ability to form strong covalent bonds makes it useful in materials like borosilicate glass, known for its resistance to thermal shock and chemical corrosion. Boron compounds are also vital in agriculture as micronutrients, enhancing plant growth and crop yields. Additionally, boron plays a crucial role in semiconductor manufacturing, where it's used as a dopant to modify the electrical properties of materials. Furthermore, boron is employed in nuclear reactors as a neutron absorber and in certain types of rockets as a fuel additive. Its wide-ranging applications underscore its significance in both scientific research and practical technology.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        // Initialize views
        eleme_list = findViewById(R.id.listview);
        detailTextView = findViewById(R.id.element_description_text_view);

        // Create ArrayAdapter to populate ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, element);

        // Set adapter to ListView
        eleme_list.setAdapter(adapter);

        // Set item click listener for ListView
        eleme_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parents, View v, int position_item, long id) {
                // Display description of the selected element in TextView
                detailTextView.setText(descriptions[position_item]);
            }
        });
    }
}
