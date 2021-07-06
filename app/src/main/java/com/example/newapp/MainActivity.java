package com.example.newapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

public class MainActivity extends AppCompatActivity
{

    private static String OAUTH_CLIENT_ID = "5FxhQiIWYotPKzWLQvsi";
    private static String OAUTH_CLIENT_SECRET = "YAW4wEZf3U";
    private static String OAUTH_CLIENT_NAME = "NewApp";

    private static OAuthLogin mOAuthLoginInstance;
    private static Context mContext;

    private ImageButton button_KakaoLogin;
    private SignInButton button_GoogleLogin;
    private OAuthLoginButton mOAuthLoginButton;

    private TextView mApiResultText;
    private static TextView mOauthAT;
    private static TextView mOauthRT;
    private static TextView mOauthExpires;
    private static TextView mOauthTokenType;
    private static TextView mOAuthState;
    private static TextView mOAuthID;

    private static String staticAccessToken;

    private static Button doInBackGround;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions googleSignInOptions
                = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();




        mContext = this;


        initData();
        initView();

        this.setTitle("OAuthLoginSample Ver." + OAuthLogin.getVersion());

        //Log.d("Account_Info", googleSignInOptions.getServerClientId().toString());
        //Log.d("Account_Info", googleSignInOptions.getAccount().toString());


        GoogleSignInClient mGoogleSignInClient= GoogleSignIn.getClient(this,googleSignInOptions);



        button_KakaoLogin=(ImageButton)findViewById(R.id.Btn_KakaoLogin);
        button_GoogleLogin=findViewById(R.id.Btn_GoogleLogin);
        button_GoogleLogin.setSize(SignInButton.SIZE_STANDARD);

       // mOAuthLoginButton=(OAuthLoginButton)findViewById(R.id.Btn_NaverLogin);



        button_KakaoLogin.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v)
             {

             }
         });

        button_GoogleLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.Btn_GoogleLogin:
                        signIn();
                        break;
                }

            }

            private void signIn()
            {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent,0);
            };

        });

        //button_NaverLogin.setOAuthLoginHandler();

        Log.d("here", "onCreate");


        doInBackGround.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("here","btn_doInBackGround");
                NaverMemberProfile naverMemberProfile = new NaverMemberProfile();
                naverMemberProfile.execute(staticAccessToken);
            }
        });


    }

    private void initData() {
        mOAuthLoginInstance = OAuthLogin.getInstance();

        mOAuthLoginInstance.showDevelopersLog(true);
        mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);

        /*
         * 2015년 8월 이전에 등록하고 앱 정보 갱신을 안한 경우 기존에 설정해준 callback intent url 을 넣어줘야 로그인하는데 문제가 안생긴다.
         * 2015년 8월 이후에 등록했거나 그 뒤에 앱 정보 갱신을 하면서 package name 을 넣어준 경우 callback intent url 을 생략해도 된다.
         */
        //mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_callback_intent_url);
    }

    private void initView() {
        mApiResultText = (TextView) findViewById(R.id.api_result_text);

        mOauthAT = (TextView) findViewById(R.id.oauth_access_token);
        mOauthRT = (TextView) findViewById(R.id.oauth_refresh_token);
        mOauthExpires = (TextView) findViewById(R.id.oauth_expires);
        mOauthTokenType = (TextView) findViewById(R.id.oauth_type);
        mOAuthState = (TextView) findViewById(R.id.oauth_state);

        mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.Btn_NaverLogin);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

        doInBackGround = (Button) findViewById(R.id.doInBackGround) ;

        updateView();
    }

    private void updateView() {
        mOauthAT.setText(mOAuthLoginInstance.getAccessToken(mContext));
        mOauthRT.setText(mOAuthLoginInstance.getRefreshToken(mContext));
        mOauthExpires.setText(String.valueOf(mOAuthLoginInstance.getExpiresAt(mContext)));
        mOauthTokenType.setText(mOAuthLoginInstance.getTokenType(mContext));
        mOAuthState.setText(mOAuthLoginInstance.getState(mContext).toString());
    }

    static private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler()
    {
        @Override
        public void run(boolean success)
        {
            if (success)
            {
                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);

                Log.d("here", accessToken);

                staticAccessToken=accessToken;

                //mOAuthLoginInstance.requestApi(mContext,accessToken,"https://openapi.naver.com/v1/nid/me");
                mOauthAT.setText(accessToken);
                mOauthRT.setText(refreshToken);
                mOauthExpires.setText(String.valueOf(expiresAt));
                mOauthTokenType.setText(tokenType);
                mOAuthState.setText(mOAuthLoginInstance.getState(mContext).toString());

            }
            else
                {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }

    };

    public void onButtonClick(View v) throws Throwable {

        switch (v.getId()) {
            case R.id.buttonOAuth: {
                mOAuthLoginInstance.startOauthLoginActivity(MainActivity.this, mOAuthLoginHandler);

                break;
            }
            case R.id.buttonVerifier: {
                new RequestApiTask().execute();
                break;
            }
            case R.id.buttonRefresh: {
                new RefreshTokenTask().execute();
                break;
            }
            case R.id.buttonOAuthLogout: {
                mOAuthLoginInstance.logout(mContext);
                updateView();
                break;
            }
            case R.id.buttonOAuthDeleteToken: {
                new DeleteTokenTask().execute();
                break;
            }
            default:
                break;
        }
    }

    private class DeleteTokenTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... params)
        {
            boolean isSuccessDeleteToken = mOAuthLoginInstance.logoutAndDeleteToken(mContext);

            if (!isSuccessDeleteToken)
            {
                // 서버에서 token 삭제에 실패했어도 클라이언트에 있는 token 은 삭제되어 로그아웃된 상태이다
                // 실패했어도 클라이언트 상에 token 정보가 없기 때문에 추가적으로 해줄 수 있는 것은 없음
                Log.d("Naver", "errorCode:" + mOAuthLoginInstance.getLastErrorCode(mContext));
                Log.d("Naver", "errorDesc:" + mOAuthLoginInstance.getLastErrorDesc(mContext));
            }

            return null;
        }

        protected void onPostExecute(Void v) {
            updateView();
        }
    }

    private class RequestApiTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            mApiResultText.setText((String) "");
        }

        @Override
        protected String doInBackground(Void... params) {
            String url = "https://openapi.naver.com/v1/nid/me";
            String at = mOAuthLoginInstance.getAccessToken(mContext);
            return mOAuthLoginInstance.requestApi(mContext, at, url);
        }

        protected void onPostExecute(String content) {
            mApiResultText.setText((String) content);
        }
    }

    private class RefreshTokenTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            return mOAuthLoginInstance.refreshAccessToken(mContext);
        }

        protected void onPostExecute(String res) {
            updateView();
        }
    }










    @Override
    protected void onStart()
    {
        super.onStart();

        GoogleSignInAccount googleSignInAccount
                = GoogleSignIn.getLastSignedInAccount(this);
        //updateUI(googleSignInAccount);

        Log.d("Account_Info", "onStart()");
    }

    @Override
    protected void onActivityResult
            (int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask)
    {
        try
        {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Log.d("Account_Info", account.getAccount().toString());
            Log.d("Account_Info", account.getDisplayName().toString());
            Log.d("Account_Info", account.getEmail().toString());
            Log.d("Account_Info", account.getFamilyName().toString());
            Log.d("Account_Info", account.getGivenName().toString());
            Log.d("Account_Info", account.getId().toString());




            //Log.d("Account_Info", account.getIdToken().toString());
        }
        catch (ApiException apiException)
        {
            Log.d("Error:ApiException","SignInResult: failed Code");
        }
    }
}