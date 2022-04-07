<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>펀딩 글쓰기</title>
  	<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
      <link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
    
</head>
<body>
    <h1>펀딩 글쓰기</h1>
  <div id="editor"></div>
    <button onclick="publish()">출간하기</button>
    <script>
    const Editor = toastui.Editor;

    const editor = new Editor({
    	  el: document.querySelector('#editor'),
    	  height: '500px',
    	  initialEditType: 'wysiwyg',
    	  previewStyle: 'vertical'
    	});

        
        function publish(){
        	const data = editor.getHTML();
        	console.log(data);
        }
        

    </script>
    
</body>
</html>