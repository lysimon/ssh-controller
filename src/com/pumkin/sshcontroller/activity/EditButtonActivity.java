package com.pumkin.sshcontroller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pumkin.sshcontroller.object.Button;
import com.pumkin.sshcontroller.object.Controller;

public class EditButtonActivity extends SshControllerActivity {

	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_button);
		button=controller.getButtonByUuid(getIntent().getExtras().get("uuid").toString());
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.push_right_in,
				R.anim.push_right_out);
		finish();
	}
	
	public void editButtonAction(View v) {
		Log.d(this.getClass().toString(), "editButtonAction for uuid "+button.uuid);
		Intent startNewActivityOpen = new Intent(
				EditButtonActivity.this, EditButtonActionActivity.class);
		startNewActivityOpen.putExtra("uuid", button.uuid);
		startActivityForResult(startNewActivityOpen, 0);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}
	
	public void editButtonDesign(View v) {
		Log.d(this.getClass().toString(), "editButtonDesign for uuid "+button.uuid);
		Intent startNewActivityOpen = new Intent(
				EditButtonActivity.this, EditButtonDesignActivity.class);
		startNewActivityOpen.putExtra("uuid", button.uuid);
		startActivityForResult(startNewActivityOpen, 0);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}
	
	public void deleteButton(View v) {
		Log.d(this.getClass().toString(), "deleteButton for uuid "+button.uuid);
		controller.deleteButtonByUuid(button.uuid);
		onBackPressed();
	}
}
