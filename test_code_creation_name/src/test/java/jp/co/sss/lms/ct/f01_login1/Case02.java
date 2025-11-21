package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		// TODO ここに追加
		//トップページへ遷移
		String topPage = "http://localhost:8080/lms/";
		goTo(topPage);
		//待ち処理
		visibilityTimeout(By.tagName("body"),60);
		//エビデンスを取得
		getEvidence(new Case02() {},"トップページへ画面遷移");
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
	void test02() {
		// TODO ここに追加
		//未登録のログインIDを入力
		sendKeysIntoNameElement("loginId","TestId001");
		getEvidence(new Case02() {},"未登録のログインID入力");
		//パスワードを入力
		sendKeysIntoNameElement("password","TestPw001");
		getEvidence(new Case02() {},"未登録のログインPW入力");
		//ログインボタンを押下
		clickButton(".btn.btn-primary");
		//エビデンスを取得
		getEvidence(new Case02() {},"未登録ユーザーでログイン");
	}

}
