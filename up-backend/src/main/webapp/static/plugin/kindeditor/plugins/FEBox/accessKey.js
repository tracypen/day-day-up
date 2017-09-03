
//hotKeyArr 保存快捷键信息的数组;
    function KeyObj(){ 
        //单键数组
        this.hotKeyArr=new Array();   
        //this.hotKeyArr[0]=['xx','test2()','2'];
        //组合键数组
        this.dbKeyArr=new Array();
        //this.dbKeyArr[0]=['xx','test2()','ctrl+1'];
        this.create=KeyObj_create;    //创建方法
        this.checkParam=KeyObj_checkParam;   //参数合法性检查方法
        this.check=KeyObj_check;    //快捷键重叠检查方法
        this.run=KeyObj_run;        //IE中键盘按下事件处理方法
        this.init=KeyObj_init;      //初始化后需要调用的方法 初始化了一些快捷键 必须调用该方法
        this.sort=KeyObj_sort;      //组合键整理位置方法
        this.firefox=KeyObj_firefox;  //火狐中处理键盘按下事件 
        this.convertTosttring=KeyObj_numToStr;
        //document.onkeydown=this.create;  
        if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){    
           document.onkeypress=this.firefox;      
        }
         //IE 添加监听
        if (jQuery.browser.msie ){
			 document.attachEvent("onkeydown",this.run);	        
        }else if(window.attachEvent){
			document.addEventListener("keydown",this.firefox,false);	       
        }    
    } 
    /**
     * @desc: 创建快捷键    
     * @param: obj 快捷键标识 用来识别不同的快捷键 相当于ID 
     * @param: method 快捷键按下需要调用的方法
     * @param: alone 当传进来的参数只有三个时（只有一个快捷键）为单个快捷键的信息（ASCII码或者ASCII吗+热键字符） 当参数有四个时此参数为单个快捷键的ASCII码 
     * @param: dbstr 当这个参数有值时 此参数为组合键的信息（ASCII码+热键字符）热键不能超过两个
     */
    function KeyObj_create(obj,methodParam,alone,dbstr){ 
         //debugger;
        var hotKeyArr=KeyCode.hotKeyArr; 
        var dbKeyArr=KeyCode.dbKeyArr; 
        //debugger;
        var method=KeyCode.convertTosttring(methodParam);
        //debugger;
        var hotKeyNum=hotKeyArr.length;
        var dbKeyNum=dbKeyArr.length;
        //如果传了值进来 代表是鼠标点击操作 
        if ( obj&&obj!=""){        
            if (!alone||alone==""){
                alert("参数有误");
                return;
            }    
            var keystr=alone.toLowerCase();
            var doublekey;  
            if (dbstr&&dbstr!=""){
                doublekey= dbstr.toLowerCase();  
            }
            //循环单键数组 查看是否已经创建     
            for (var i=0;i<hotKeyArr.length;i++){
                //如果存在就执行
                if (hotKeyArr[i][0]==obj){
                    eval(method);
                    return;
                }  
            }
             //循环组合键数组 
            for (var i=0;i<dbKeyArr.length;i++){          
                if (dbKeyArr[i][0]==obj){
                    eval(method);  
                    return;
                }  
            } 
            //如果循环完了 还没有找到相应的信息 就创建                           
            //如果有四个参数    
            if (keystr&&keystr!=""&&doublekey&&doublekey!=""){  
                //检查参数是否合法 返回一个布尔值
                var flag=KeyCode.checkParam(keystr); 
                var flag1=KeyCode.checkParam(doublekey);  
                var sortstr;       
                if (flag&&flag1){ 
                    //组合键需要整理一下位置（按 数字>ctrl>shift>alt 的优先级排序）  
                    sortstr=KeyCode.sort(doublekey);                                  
	                for (var i=0;i<hotKeyArr.length;i++){
	                    if (keystr==hotKeyArr[i][2]){
	                        alert("快捷键重叠--单键重叠");
	                        return;
	                    }
	                }
	                for (var i=0;i<dbKeyArr.length;i++){	                
	                    if (sortstr==dbKeyArr[i][2]){
	                        alert("快捷键重叠--组合键重叠");
	                        return;
	                    }
	                } 	
	                //如果没有重叠就创建    
	                //debugger;                    
	                var hotarr=new Array();               
	                hotarr[0]=obj;
	                hotarr[1]=method;                 
	                hotarr[2]=keystr;
	                //保存单键数组
	                hotKeyArr[hotKeyNum]=hotarr;  
	                var dbarr=new Array();               
	                dbarr[0]=obj;
	                dbarr[1]=method;                 
	                dbarr[2]=sortstr;
	                //保存组合键数组
	                dbKeyArr[dbKeyNum]=dbarr;  	                
	               // eval(method);
	                return;  
                }                                          	                                  	                 
             }          
             //如果是三个参数 
             else if (keystr&&keystr!=""&&(!doublekey||doublekey=="")){    
                 //检测参数是否合法     
                 var flag=KeyCode.checkParam(keystr)  
                 if (flag){
                     var splitarr=new Array();
                     splitarr=keystr.split("+");
                      //可能是组合键 需要排序整理位置 
                     var sortstr=KeyCode.sort(keystr);                
                     if (splitarr.length==1){
                         for (var i=0;i<hotKeyArr.length;i++){
		                     if (keystr==hotKeyArr[i][0]){
		                         alert("快捷键重叠--单键重叠");
		                         return;
		                     }   		            
                         }
                         var hotarr=new Array();               
		                 hotarr[0]=obj;
		                 hotarr[1]=method;                 
		                 hotarr[2]=sortstr;
		                 //保存单键数组		            
		                 hotKeyArr[hotKeyNum]=hotarr; 	 		               	                                                                  
		                 //eval(method);
		                 return; 
                    }
                    //如果是组合键
                    else if(splitarr.length>1){                                   
	                    for (var i=0;i<dbKeyArr.length;i++){
	                        //需要比较的字段也整理一下位置
	                        var sortstr=KeyCode.sort(keystr);                  
	                        if (sortstr==dbKeyArr[i][2]){
	                            alert("快捷键重叠--组合键重叠");
	                            return;
	                        }   	                            
	                    }
	                    var hotarr=new Array();               
                        hotarr[0]=obj;
                        hotarr[1]=method;                 
                        hotarr[2]=sortstr;	                     
                        //保存单键数组
                        dbKeyArr[dbKeyNum]=hotarr;   		                                                            
                        //eval(method);
                        return; 
                   }     
                } 
           }            
        }
        //如果没有传值进来---键盘按下事件处理
        else if (!obj||obj==""){  
           if (document.all){
               var hotkey=0;
               hotkey=event.keyCode;
	           var e=event;
	           KeyObj_run(e,hotkey);    
           }   
        } 
    }



    /**
     * @desc: 执行键盘按下事件  
     * @param: e 键盘按下的事件源
     */
    function KeyObj_run(e,hotkey){
       //debugger;
         if(typeof hotkey == 'undefined')
            hotkey = e.keyCode;
        //得到所单键数组
        var hotKeyArr=KeyCode.hotKeyArr;  
        //得到组合键数组
        var dbKeyArr=KeyCode.dbKeyArr;  
        var arr=new Array();  
        //循环组合数组
        var hotcode;
        var hotstr; 
        var method 
        var splitstr;
       
        //循环组合键数组
        for(var i=0;i<dbKeyArr.length;i++){      
             method=dbKeyArr[i][1];               
             splitstr=dbKeyArr[i][2];              
             arr=splitstr.split("+");   
             if (arr.length==4){            
                 hotcode=arr[0];
                 hotstr=arr[1]+"+"+arr[2]+"+"+arr[3];
                 if (hotstr=="ctrl+shift+alt"&&e.ctrlKey&&e.shiftKey&&e.altKey&&hotkey==hotcode){
	                 eval(method);	
	                 return false;
		         }                  
	          }                         
        }
        for(var i=0;i<dbKeyArr.length;i++){      
             method=dbKeyArr[i][1];               
             var splitstr=dbKeyArr[i][2];              
             arr=splitstr.split("+");
             if (arr.length==3){				
                 hotcode=arr[0];
                 hotstr=arr[1]+"+"+arr[2];
                 if (hotstr=="ctrl+shift"&&e.ctrlKey>=1&&e.shiftKey>=1&&hotkey==hotcode){
	                 eval(method);		   
	                 return false;
		         }
		         if (hotstr=="ctrl+alt"&&e.ctrlKey>=1&&e.altKey>=1&&hotkey==hotcode){
		             eval(method);
		             return false;		          
		         }
		         if (hotstr=="shift+alt"&&e.altKey>=1&&e.shiftKey>=1&&hotkey==hotcode){
		             eval(method);	
		             return false;
		         }  
             }  
         }
         for(var i=0;i<dbKeyArr.length;i++){      
             method=dbKeyArr[i][1];               
             var splitstr=dbKeyArr[i][2];              
             arr=splitstr.split("+");
             if (arr.length==2){
                 hotcode=arr[0];
                 hotstr=arr[1];
                 //如果热键是ctrl且同时按下了ctrl和配合键
		         if (hotstr=="ctrl"&&e.ctrlKey>=1&&hotkey==hotcode){
		             eval(method);
		             return false;
		         }
		         if (hotstr=="shift"&&e.shiftKey>=1&&hotkey==hotcode){
		             eval(method);
		             return false;
		         }
		         if (hotstr=="alt"&&e.altKey>=1&&hotkey==hotcode){
		             eval(method);						
		             return false;	        	    
		         }
             } 
         }      
        //循环单键数组
        for (var i=0;i<hotKeyArr.length;i++){           
             var splitstr=hotKeyArr[i][2];
             arr= splitstr.split("+");
             //如果ascii码相同而且又是单键 
             if (hotkey==arr[0]&&arr.length==1){     
	             eval(hotKeyArr[i][1])
	             return false;
             } 
        }
    }    
    /**
     * @desc: 键盘操作处理  
     * @param: e 键盘按下的事件源
     */
    function KeyObj_firefox(e){
        var hotKeyArr=KeyCode.hotKeyArr;
        window.document.body.focus()  
        //支持重复按下（火狐中需要） 
        e.repeat = true;
        //得到键盘按下的ASCII码 ;
        var hotkey=0,ee=e||event;
        e = e ? e : (window.event ? window.event : null);
        hotkey=e.keyCode||e.which||e.charCode;  
        //鼠标按下事件处理   
        KeyObj_run(e,hotkey)
    }

    //已经创建的组合键 整理它们的位置
    function KeyObj_init(){
        var dbKeyArr=KeyCode.dbKeyArr;   
        var hotKeyArr=KeyCode.hotKeyArr;
        for (var i=0;i<dbKeyArr.length;i++){    
            //检查每个参数的合法性                 
            var flag=KeyCode.checkParam(dbKeyArr[i][2]);
            if (flag){
                //调用 整理位置的方法 优先级（数字>ctrl>shift>alt）
                var sortstr=KeyCode.sort(dbKeyArr[i][2]);
                dbKeyArr[i][2]=sortstr;
            }            
        }
        for (var j=0;j<hotKeyArr.length;j++){        
             var hotkey=hotKeyArr[j][2];
             if (isNaN(hotkey)||hotkey<=0){
                alert("快捷键信息有误---单键只能传大于0的数字");  
                return;
             }
        }
    }
    /**
     * @desc: 整理字段位置    
     * @param: splitstr 需要重新整理位置的字符串
     */
    function KeyObj_sort(splitstr){
        var keyarr=new Array();    
        //根据+ 号切割字符串 并根据优先级重新排列位置         
        keyarr=splitstr.split("+"); 
        //排序后的字段
        var sortedstr;
        //如果没有+号  则不需要重新排列 
        if (keyarr.length==1){
           sortedstr=keyarr[0];
           return sortedstr;
        }  
        //如果是只有一个+号 则只有一个热键 并把数字放前面
        if (keyarr.length==2){             
            if (!isNaN(keyarr[0])){
               sortedstr=keyarr[0]+"+"+keyarr[1];
               return sortedstr;
            }else{
               sortedstr=keyarr[1]+"+"+keyarr[0];
               return sortedstr;
            }        
        }
        //如果有两个+号 则有两个热键 并根据优先级大小重新排序
        else if (keyarr.length==3){               
             var str1=keyarr[0];
             var str2=keyarr[1];
             var str3=keyarr[2];
             if (!isNaN(str1)){                
                 if (str2=="ctrl"){
                     sortedstr=str1+"+"+str2+"+"+str3;
                     return sortedstr;
                 }
                 else if(str2=="shift"&&str3=="ctrl"){
                     sortedstr=str1+"+"+str3+"+"+str2;
                     return sortedstr;
                 }
                 else if(str2=="shift"&&str3=="alt"){
                     sortedstr=str1+"+"+str2+"+"+str3;
                     return sortedstr;
                 }
                 else if(str2=="alt"){
                     sortedstr=str1+"+"+str3+"+"+str2;
                     return sortedstr;
                 }            
             }
             else if(!isNaN(str2)){
                 if (str1=="ctrl"){
                     sortedstr=str2+"+"+str1+"+"+str3;
                     return sortedstr;
	             }
	             else if(str1=="shift"&&str3=="ctrl"){
	                 sortedstr=str2+"+"+str3+"+"+str1;
	                 return sortedstr;
	             }
	             else if(str1=="shift"&&str3=="alt"){
	                 sortedstr=str2+"+"+str1+"+"+str3;
	                 return sortedstr;
	             }
	             else if(str1=="alt"){
	                 sortedstr=str2+"+"+str3+"+"+str1;
	                 return sortedstr;
	             }
           }
           else if(!isNaN(str2)){
               if (str2=="ctrl"){
                   sortedstr=str1+"+"+str2+"+"+str3;
                   return sortedstr;
               }
               else if(str2=="shift"&&str3=="ctrl"){
                   sortedstr=str1+"+"+str3+"+"+str2;
                   return sortedstr;
               }
               else if(str2=="shift"&&str3=="alt"){
                    sortedstr=str1+"+"+str2+"+"+str3;
                    return sortedstr;
               }
               else if(str2=="alt"){
                    sortedstr=str1+"+"+str3+"+"+str2;
                    return sortedstr;
               }
           }
        }
         //如果有三个+号 则有两个热键 并根据优先级大小重新排序
        else if (keyarr.length==4){               
             var str1=keyarr[0];
             var str2=keyarr[1];
             var str3=keyarr[2];
             var str4=keyarr[3];
             if(!isNaN(str1)){
               sortedstr=str1+"+ctrl+shift+alt";
                return sortedstr;         
             } 
             else if(!isNaN(str2)){
                 sortedstr=str2+"+ctrl+shift+alt";
                 return sortedstr;         
             } 
             else if(!isNaN(str3)){
                 sortedstr=str3+"+ctrl+shift+alt";
                 return sortedstr;         
             } 
             else if(!isNaN(str4)){
                 sortedstr=str4+"+ctrl+shift+alt";
                 return sortedstr;         
             } 
        }
        return sortedstr;
    }
    /**
     * @desc: 参数合法验证
     * @param: str 需要验证的字符
     */    
    function KeyObj_checkParam(str){   
        if (str&&str!=""){
           var keyarr=new Array();
           keyarr=str.split("+");
            //如果长度为1且存在则必须为数字 
           if (keyarr.length==1&&keyarr[0]&&keyarr[0]!=""){
               var isnum=keyarr[0];
               if (!isNaN(isnum)){
                   return true;
               } else{
                  alert("快捷键信息有误 创建失败！（提示：单键需传ASCII码值）");
                  return false;
               }       
            }
	        //如果长度为2 则为组合键且只有一个热键
	        else if(keyarr.length==2){  
	            //如果两个数都存在      
	            if (keyarr[0]&&keyarr[1]){
	                var key1=keyarr[0];
	                var key2=keyarr[1];
	                //如有一个数字一个热键
	                if (!isNaN(key1)){    
	                     if (key2=="ctrl"||key2=="shift"||key2=="alt"){
	                         return true;
	                     }else{
	                         alert("不支持的热键(热键只能是ctrl,shift,alt之中的一个或两个)");
	                         return false;
	                     }
	                }
	                else if (!isNaN(key2)){    
	                     if(key1=="ctrl"||key1=="shift"||key1=="alt"){
	                       return true;
	                     }else{
	                       alert("不支持的热键(热键只能是ctrl,shift,alt之中的一个或两个)");
	                       return false;
	                     }
	                }else {
	                    alert("快捷键信息有误！（提示：格式不正确）");
	                    return false;               
	                }         
	             }else {
	                alert("快捷键信息有误！）");
	                return false;             
	             }                 
	         } 
	         //如果长度为3 则为组合键且有两个热键
	         else if(keyarr.length==3){         
	             //如果都存在       
	             if (keyarr[0]&&keyarr[1]&&keyarr[2]&&key1!=""&&key1!=""&&key3!=""){
	                 var key1=keyarr[0];
	                 var key2=keyarr[1]; 
	                 var key3=keyarr[2];
		             //如第一个是数字
		             if (!isNaN(key1)){    
		                 if ((key2=="ctrl"&&(key3=="shift"||key3=="alt"))||(key2=="shift"&&(key3=="ctrl"||key3=="alt"))||(key2=="alt"&&(key3=="ctrl"||key3=="shift"))){
		                     return true;
		                 }else{
		                     alert("不支持的热键(热键只能是ctrl,shift,alt之中的一个或两个)");
		                     return false;
		                 }
    		                           
		             } //如第二个是数字		         
		             else if (!isNaN(key2)){    
		                 if ((key1=="ctrl"&&(key3=="shift"||key3=="alt"))||(key1=="shift"&&(key3=="ctrl"||key3=="alt"))||(key1=="alt"&&(key3=="ctrl"||key3=="shift"))){
		                     return true;
		                 }else{
		                     alert("不支持的热键(热键只能是ctrl,shift,alt之中的一个或两个)");
		                     return false;
		                 }                
		             }  //如第三个是数字		          
		             else if (!isNaN(key3)){    
		                 if ((key1=="ctrl"&&(key2=="shift"||key2=="alt"))||(key1=="shift"&&(key2=="ctrl"||key2=="alt"))||(key1=="alt"&&(key2=="ctrl"||key2=="shift"))){
		                     return true;
		                 } else{
		                     alert("不支持的热键(热键只能是ctrl,shift,alt之中的一个或两个)");
		                     return false;
		                 }               
		             } //如果不存在数字
		             else {
	                    alert("快捷键信息有误！");
	                    return false;               
	                 }
	              }                
	          }
	          //如果有三个热键
	          else if(keyarr.length==4){    
	             //如果都存在       
	             if (keyarr[0]&&keyarr[1]&&keyarr[2]&&keyarr[3]&&key1!=""&&key1!=""&&key3!=""&&key3!=""){
	                 var key1=keyarr[0];
	                 var key2=keyarr[1]; 
	                 var key3=keyarr[2];
	                 var key4=keyarr[3];
		             //如第一个是数字
		             if (!isNaN(key1)){    
		                 if ((key2=="ctrl"&&key3=="shift"&&key4=="alt")||(key2=="ctrl"&&key3=="alt"&&key4=="shift")||(key2=="shift"&&key3=="ctrl"&&key4=="alt")||(key2=="shift"&&key3=="alt"&&key4=="ctrl")||(key2=="alt"&&key3=="ctrl"&&key4=="shift")||(key2=="alt"&&key3=="shift"&&key4=="ctrl")){
		                     return true;
		                 }else{
		                     alert("不支持的热键(热键只能是ctrl,shift,alt之间的单个或组合)");
		                     return false;
		                 }
    		                           
		             } 
		             //如第二个是数字
		             else if (!isNaN(key2)){    
		                 if ((key1=="ctrl"&&key3=="shift"&&key4=="alt")||(key1=="ctrl"&&key3=="alt"&&key4=="shift")||(key1=="shift"&&key3=="ctrl"&&key4=="alt")||(key1=="shift"&&key3=="alt"&&key4=="ctrl")||(key1=="alt"&&key3=="ctrl"&&key4=="shift")||(key1=="alt"&&key3=="shift"&&key4=="ctrl")){
		                     return true;
		                 }else{
		                     alert("不支持的热键(热键只能是ctrl,shift,alt之间的单个或组合)");
		                     return false;
		                 }               
		             }  
		              //如第三个是数字
		             else if (!isNaN(key3)){    
		                 if ((key1=="ctrl"&&key2=="shift"&&key4=="alt")||(key1=="ctrl"&&key2=="alt"&&key4=="shift")||(key1=="shift"&&key2=="ctrl"&&key4=="alt")||(key1=="shift"&&key2=="alt"&&key4=="ctrl")||(key1=="alt"&&key2=="ctrl"&&key4=="shift")||(key1=="alt"&&key2=="shift"&&key4=="ctrl")){
		                     return true;
		                 }else{
		                     alert("不支持的热键(热键只能是ctrl,shift,alt之间的单个或组合)");
		                     return false;
		                 }             
		             }
		              //如第四个是数字
		             else if (!isNaN(key4)){    
		                 if ((key1=="ctrl"&&key2=="shift"&&key3=="alt")||(key1=="ctrl"&&key2=="alt"&&key3=="shift")||(key1=="shift"&&key2=="ctrl"&&key3=="alt")||(key1=="shift"&&key2=="alt"&&key3=="ctrl")||(key1=="alt"&&key2=="ctrl"&&key3=="shift")||(key1=="alt"&&key2=="shift"&&key3=="ctrl")){
		                     return true;
		                 }else{
		                     alert("不支持的热键(热键只能是ctrl,shift,alt之间的单个或组合)");
		                     return false;
		                 }             
		             }         
		              else {
	                    alert("快捷键信息有误！");
	                    return false;               
	                 }
	              } 
	             alert("快捷键信息有误！（提示：格式不正确）");
	             return false;
	          }            
        }else{
        //如果没有传参数进来或者参数为空
            alert("参数无效！");
            return false;
        }   
    }
    /**
     * @desc: 验证初始化的(已创建的)快捷键是否有重叠现象（随便验证格式正确性）
     */
    function KeyObj_check(){
        var hotKeyArr=KeyCode.hotKeyArr; 
        var dbKeyArr=KeyCode.dbKeyArr; 
        //先整理好数组的位置再来检验（顺便已经完成了 格式验证！）
        KeyCode.init();         
        for (var i=0;i<hotKeyArr.length;i++){                          
            for(var j=i+1;j<hotKeyArr.length;j++){
                 if(hotKeyArr[i][0]==hotKeyArr[j][0]){
                    alert("快捷键重叠——标识重叠");
                    return;
                 }
                 if(hotKeyArr[i][1]==hotKeyArr[j][1]){
                    alert("快捷键重叠——标识重叠");
                    return;
                 }  
            }
        }      
        for (var i=0;i<dbKeyArr.length;i++){ 
            for (var j=i+1;j<dbKeyArr.length;j++){
                 if (hotKeyArr[i][0]==hotKeyArr[j][0]){
                     alert("快捷键重叠——标识重叠");
                     return;
                 }
                 if (hotKeyArr[i][1]==hotKeyArr[j][1]){
                     alert("快捷键重叠——组合重叠");
                     return;
                 }  
            }   
        } 
    }
    //字符转成Keycode吗
    function KeyObj_strToNum(str) {
	    var num_out = "";
	    if (str == "") 
	    alert("没有要加密的东东");
	    else {
	        var str_in = escape(str);
	        for (i = 0; i < str_in.length; i++) {
	            num_out += str_in.charCodeAt(i) - 23;
	        }
		    return num_out;
       } 
    }
    //KeyCode码在换回原来的字符
    function KeyObj_numToStr(num) {
	    var str_out = "";
	    if(num == "") alert("没有要解密的东东");
	    else {
			var num_out = num;  
			for(i = 0; i < num_out.length; i += 2) {
			 var num_in = parseInt(num_out.substr(i,[2])) + 23;
			 num_in = unescape('%' + num_in.toString(16));
			 str_out += num_in;
			}
			return unescape(str_out);
	   }
	}
    var KeyCode = new KeyObj();

	//字符转成Keycode吗   
	function str_to_num(str) {   
		var num_out = "";   
		if (str == "")    
		alert("没有要加密的东东");   
		else {   
			var str_in = escape(str);   
			for (i = 0; i < str_in.length; i++) {   
				num_out += str_in.charCodeAt(i) - 23;   
			}         
			return num_out;   
	   }    
	}   
	//KeyCode码在换回原来的字符   
	function num_to_str(num) {   
		var str_out = "";   
		if(num == "") alert("没有要解密的东东"); 
		else {   
		var num_out = num;     
		for(i = 0; i < num_out.length; i += 2) {   
		 var num_in = parseInt(num_out.substr(i,[2])) + 23;   
		 num_in = unescape('%' + num_in.toString(16));   
		 str_out += num_in;   
	   }   
	   return unescape(str_out);   
	   }   
	}   