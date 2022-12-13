
 
<link rel="stylesheet" type="text/css" href="${resRoot}/flexpaper/css/flexpaper.css" />
<script type="text/javascript" src="${resRoot}/flexpaper/js/jquery.min.js"></script>
<script type="text/javascript" src="${resRoot}/flexpaper/js/flexpaper.js"></script>
<script type="text/javascript" src="${resRoot}/flexpaper/js/flexpaper_handlers.js"></script>

<div style="position:absolute;left:100px;top:100px;">
<div id="documentViewer" class="flexpaper_viewer" style="width:770px;height:500px"></div>

<script type="text/javascript">
   
   

    var startDocument = "Paper";

    $('#documentViewer').FlexPaperViewer(
            { config : {

                SWFFile : escape('s.swf'),

                Scale : 0.6,
                ZoomTransition : 'easeOut',
                ZoomTime : 0.5,
                ZoomInterval : 0.2,
                FitPageOnLoad : false,
                FitWidthOnLoad : true,
                FullScreenAsMaxWindow : false,
                ProgressiveLoading : false,
                MinZoomSize : 0.2,
                MaxZoomSize : 5,
                SearchMatchAll : false,
                InitViewMode : 'Portrait',
                RenderingOrder : 'flash,html',
                StartAtPage : '',

                ViewModeToolsVisible : true,
                ZoomToolsVisible : true,
                NavToolsVisible : true,
                CursorToolsVisible : true,
                SearchToolsVisible : true,
                WMode : 'window'
            }}
    );
</script>

