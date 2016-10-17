package deint.jroldan.dynamictable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * @author Jesús Roldán López
 * @version 1.0
 * Exercise shows how to create components at runtime.-
 * -layoutparams
 * -shape
 * -array-string
 * -colors
 */

public class DynamicTable_Activity extends AppCompatActivity {

    private TableLayout tblHeader;
    private TableLayout tblBody;
    private TableRow.LayoutParams tbrLayoutId;
    private TableRow.LayoutParams tbrLayoutName;
    private TableRow.LayoutParams tbrLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table);
        tblHeader = (TableLayout)findViewById(R.id.tblHeader);
        tblBody = (TableLayout)findViewById(R.id.tblBody);
        tbrLayoutId=new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayoutId.setMargins(0,10,0,10);
        tbrLayoutName=new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayout=new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        createHeader();
        createBody();
    }

    private void createHeader() {
        TableRow tbrHeader=new TableRow(this);
        tbrHeader.setLayoutParams(tbrLayout);

        TextView txvId = new TextView(this);
        txvId.setText(R.string.txvId);
        txvId.setLayoutParams(tbrLayoutId);
        txvId.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvId);

        TextView txvName = new TextView(this);
        txvName.setText(R.string.txvName);
        txvName.setLayoutParams(tbrLayoutName);
        txvName.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvName);

        tblHeader.addView(tbrHeader);
    }

    private void createBody() {
        TableRow tbrBody;
        TextView txvId;
        TextView txvName;

        String[] nameList=getResources().getStringArray(R.array.nameList);
        for(int i = 0; i < nameList.length; i++) {
            tbrBody = new TableRow(this);
            tbrBody.setLayoutParams(tbrLayout);

            txvId = new TextView(this);
            txvId.setText(" " + (i + 1) + " ");
            txvId.setLayoutParams(tbrLayoutId);
            txvId.setBackgroundResource(R.drawable.shape_body);

            txvName = new TextView(this);
            txvName.setText(nameList[i]);
            txvName.setLayoutParams(tbrLayoutName);
            txvName.setBackgroundResource(R.drawable.shape_body);

            tbrBody.addView(txvId);
            tbrBody.addView(txvName);

            tblBody.addView(tbrBody);
        }
    }
}
