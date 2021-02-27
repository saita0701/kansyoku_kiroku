$(() => {
	$('button#login').on('click', () => {
		let jsonString = {
			'userName': $('div.loginForm input[name=userName]').val(),
			'password': $('div.loginForm input[name=password]').val()
		};
		$.ajax({
			type: 'POST',
			url: '/kansyoku_kiroku/auth/login',
			data: JSON.stringify(jsonString),
			contentType: 'application/json',
			datatype: 'json',
			scriptCharset: 'utf-8'
		})
		.then((result) => {
			let user = JSON.parse(result);
			if ($.isEmptyObject(user)) {
				$('#hiddenUserName').val('');
				alert('ユーザー名またはパスワードが違います。');
			} else {
				$('#hiddenUserName').val(user['userName']);
				login(user);
				location.replace('/kansyoku_kiroku/');
			}
		}, () => {
			alert('Error: ajax connection failed.');
		});
	});
	
	$('button#logout').on('click',() => {
		$.ajax({
			type:'POST',
			url:'/kansyoku_kiroku/auth/logout',
			datatype: 'json',
			scriptCharset: 'utf-8'
		})
		.then(() => {
			$('#hiddenUserName').val('');
			logout();
			location.replace('/kansyoku_kiroku/');
			alert('ログアウトしました。');
		}, () => {
			alert('Error: ajax connection failed.');
		});
	});
	
	function login(user) {
		$('div.loginForm input[name=userName]').val('');
		$('div.loginForm input[name=password]').val('');
	}
	
	function logout() {
		$('div.loginForm input[name=userName]').val('');
		$('div.loginForm input[name=password]').val('');
	}
	
});
