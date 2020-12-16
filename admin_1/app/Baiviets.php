<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use DB;
use app\vungmiens;
use app\category;
class Baiviets extends Model
{

    protected $table="baiviets";
    public $timestamps=false;
    protected $fillable=[
    'ten',
    'chude_id',
    'vungmien_id',
    'nguyenlieu',
    'soche',
    'thuchien',
    'cachdung',
    'action',
    'created_at',
    'updated_at',
    'hinhanh',
    'ten_vungmien',
    'title',
];
public function Vungmiens(){
    return $this->belongsTo('App\vungmiens','vungmien_id');
}
    public function category(){
        return $this->belongsTo('App\category');
    }
    
}
