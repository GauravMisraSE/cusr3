
<script>
window.$(".date-picker").datepicker();

window.$(".date-picker").on("change", function () {
    var id = window.$(this).attr("id");
    var val = window.$("label[for='" + id + "']").text();
});
</script>

<div class="date-form">
    
<div class="form-horizontal">
    <div class="control-group">
        <label for="date-picker-1" class="control-label">A <span class="glyphicon glyphicon-calendar"> </span>

        </label>
        <div class="controls">
            <input id="date-picker-1" type="text" class="date-picker form-control" />
        </div>
    </div>
    <div class="control-group">
        <label for="date-picker-2" class="control-label">B</label>
        <div class="controls">
            <div class="input-group">
                <input id="date-picker-2" type="text" class="date-picker form-control" />
                <label for="date-picker-2" class="input-group-addon btn"><span class="glyphicon glyphicon-calendar"></span>

                </label>
            </div>
        </div>
    </div>
    <div class="control-group">
        <label for="date-picker-3" class="control-label">C</label>
        <div class="controls">
            <div class="input-group">
                <label for="date-picker-3" class="input-group-addon btn"><span class="glyphicon glyphicon-calendar"></span>

                </label>
                <input id="date-picker-3" type="text" class="date-picker form-control" />
            </div>
        </div>
    </div>
</div>
    
    <hr />
<div>
    <span id="msg" class="controls form-control uneditable-input"></span>
</div>
</div>