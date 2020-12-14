<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Category extends Model
{
    protected $table="categories";
    public $timestamps=false;
    protected $fillable=[
        'title',
        'action',
        'created_at',
        'updated_at',
    ];
}
