# spec/factories/items.rb
FactoryGirl.define do
  factory :item do
    name { Faker::Lorem.word }
	itemType { Faker::Lorem.word }
	value { Faker::Number.number(10) }

	user_id nil
  end
end