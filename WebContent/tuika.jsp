<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<link href="tuika.css" rel="stylesheet" type="text/css">
</head>
<body>
		<form method="post" action="tuika">	
		<div id= "gazouwaku">
			<%--↓画像はじめ↓ --%>
			<script type="text/javascript" language="javascript">
				function OnFileSelect(inputElement) {
					// ファイルリストを取得
					var fileList = inputElement.files;
					var loadCompleteCount = 0;
					var imageList = "";
						// FileReaderを生成
						var filereader = new FileReader();

						// ファイルを取得
						var file = fileList[0];

						// 読み込み完了時の処理を追加
						filereader.onload = function() {

							// <li>,<img>タグの生成
							imageList += "<li><img class='sizex' src=" + this.result + " /></li>";
								// <ul>タグに<li>,<img>を流し込む
								document.getElementById("ID001").innerHTML = imageList;	
						};

						// ファイルの読み込み(Data URI Schemeの取得)
						filereader.readAsDataURL(file);
				}
			</script>
			<label class="upload-label">
				<div class="font">ファイルを選択</div>
				<input type="file" onchange="OnFileSelect( this );" required  />
			</label>
			<ul id="ID001"></ul>
			<%--↑画像終わり↑--%>
		</div>
			<div class="font">				
				<label for="name">名前</label>
				<input type="text" name="name"   maxlength="10"style="width: 650px; height: 150px;"><br> <br> 
				<input type="text" value="0" id="textbox" name="count"style="width: 650px; height: 150px;" ><br> <br>
				<div class="sentaku">	
					<label><input class="radio"type="radio" name="comm" value="syoku" style="transform:scale(3.0)"> 食材</label>&emsp;
					<label><input class="radio"type="radio" name="comm" value="niti" style="transform:scale(3.0)">日用品 </label><br> <br>
				</div>	
			</div>
			 <br>
			<button type="submit"style="width: 250px; height: 150px;"><div class="font">追加</div></button>
	</form>

		<%--プラス,マイナス,リセットボタン --%>
		<div class="updown">	
			
				<button class="button " id="down"style="width: 150px; height: 150px;"><div class="font">－</div></button>
				<button class="button " id="up"style="width: 150px; height: 150px;"><div class="font">＋</div></button>
				<button class="button resetbtn " id="reset"style="width: 300px; height: 150px;"><div class="font">RESET</div></button>			
			<script src="tuika.js"></script>
		
		</div>
	
</body>
</html>