/** 
2  * Bootstrap Table Chinese translation 
3  * Author: Zhixin Wen<wenzhixin2010@gmail.com> 
4  */ 
5 (function ($) { 
6     'use strict'; 
7 
 
8     $.fn.bootstrapTable.locales['zh-CN'] = { 
9         formatLoadingMessage: function () { 
10             return '正在努力地加载数据中，请稍候……'; 
11         }, 
12         formatRecordsPerPage: function (pageNumber) { 
13             return '每页显示 ' + pageNumber + ' 条记录'; 
14         }, 
15         formatShowingRows: function (pageFrom, pageTo, totalRows) { 
16             return '显示第 ' + pageFrom + ' 到第 ' + pageTo + ' 条记录，总共 ' + totalRows + ' 条记录'; 
17         }, 
18         formatSearch: function () { 
19             return '搜索'; 
20         }, 
21         formatNoMatches: function () { 
22             return '没有找到匹配的记录'; 
23         }, 
24         formatPaginationSwitch: function () { 
25             return '隐藏/显示分页'; 
26         }, 
27         formatRefresh: function () { 
28             return '刷新'; 
29         }, 
30         formatToggle: function () { 
31             return '切换'; 
32         }, 
33         formatColumns: function () { 
34             return '列'; 
35         } 
36     }; 
37 
 
38     $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']); 
39 
 
40 })(jQuery); 
