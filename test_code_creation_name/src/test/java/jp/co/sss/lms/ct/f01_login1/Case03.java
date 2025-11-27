package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

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
 * ケース03
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース03 受講生 ログイン 正常系")
public class Case03 {

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
		getEvidence(new Case03() {},"トップページへ画面遷移");
		
		//検証
		String actualTitle = getTitle();
		String expectedTitle = "ログイン | LMS";
		assertEquals(expectedTitle,actualTitle,"トップページのタイトルが一致しません");		
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		// TODO ここに追加
		//受講生ユーザーIDを入力
		sendKeysIntoNameElement("loginId","StudentAA01");
		getEvidence(new Case03() {},"受講生のログインID入力");
		//パスワードを入力
		sendKeysIntoNameElement("password","StudentAA011");
		getEvidence(new Case03() {},"受講生のログインPW入力");
		//ログインボタンを押下
		clickButton(".btn.btn-primary");
		//エビデンスを取得
		getEvidence(new Case03() {},"受講生ユーザーでログイン");
		
		//検証
		String expectedTitle = "コース詳細 | LMS";
		String actualTitle = getTitle();
		assertEquals(expectedTitle,actualTitle,"画面タイトルが一致しません");
		
		String headerMsg = getMsg(".active");
		assertEquals("コース詳細",headerMsg,"パンくずリストの表示名が一致しません");
			
	}

}
