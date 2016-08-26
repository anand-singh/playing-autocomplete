if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

$('.typeahead').typeahead({
    hint: true,
    highlight: true,
    minLength: 1,
    limit: 8
}, {
    source: function(q, cb) {
        return $.ajax({
            dataType: 'json',
            type: 'post',
            url: '/autocomplete',
            data: {criteria: q},
            chache: false,
            success: function(data) {
                var result = [];
                $.each(data, function(index, val) {
                    result.push({
                        value: val.code + " : " + val.name + " - " + val.continent
                    });
                });
                cb(result);
            }
        });
    }
});
