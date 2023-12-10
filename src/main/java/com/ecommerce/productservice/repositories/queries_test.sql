select c1_0.id,
       c1_0.created_at,
       c1_0.description,
       c1_0.name,
       c1_0.updated_at,
       p1_0.category_id,
       p1_0.id,
       p1_0.created_at,
       p1_0.description,
       p1_0.image,
       p1_0.price,
       p1_0.stock,
       p1_0.title,
       p1_0.updated_at
from categories c1_0
         left join products p1_0 on c1_0.id = p1_0.category_id
where c1_0.id = ?