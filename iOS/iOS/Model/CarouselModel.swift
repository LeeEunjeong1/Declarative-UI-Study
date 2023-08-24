//
//  CarouselModel.swift
//  iOS
//
//  Created by Financial CB on 2023/08/23.
//

import Foundation

struct CarouselModel: Hashable, Codable, Identifiable {
    var id: Int
    var image: String
    var title: String
    var text: String
}

struct ScrollModel: Hashable, Codable, Identifiable {
    var id: Int
    var image: String
    var title: String
    var text: String
}
